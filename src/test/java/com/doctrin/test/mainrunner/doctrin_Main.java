package com.doctrin.test.mainrunner;

import java.io.BufferedWriter;
import com.doctrin.test.actionchains.CommonChains;
import com.doctrin.test.actionchains.ConfimedChains;
import com.doctrin.test.actionchains.DeathChains;
import com.doctrin.test.config.ConfigData;
import com.doctrin.test.utils.Library;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;

public class doctrin_Main {

	public Response response;

	String noInfectionOutput;
	String noDeathOutput;
	String ISO;

	Library library = new Library();
	ConfigData configData = new ConfigData();
	CommonChains commonChains = new CommonChains();
	ConfimedChains confimedChains = new ConfimedChains();
	DeathChains deathChains = new DeathChains();

	@Given("^Acccess and get the response of the covid API for country \"([^\"]*)\"$")
	public void acccess_and_get_the_response_of_the_covid_API_for(String ISO) throws Throwable {

		this.ISO = ISO;

		this.response = commonChains.accessAPI(ISO);

	}

	@Then("^Get the date when the number of infections was the highest and the count$")
	public void get_the_date_when_the_number_of_infections_was_the_highest_and_the_count() throws Throwable {

		confimedChains.getAllConfimedNumbers(response);

		noInfectionOutput = "The date when the number of infections was the highest is '"
				+ confimedChains.getMaxConfimedDate(response) + "' and the count for that day rose by '"
				+ confimedChains.getMaxConfimedInADay(response)
				+ "', while the total confirmed cases on that day stood at '"
				+ confimedChains.getMaxConfimedNo(response) + "'";

	}

	@And("^Get the date when the number of deaths was the highest and the count$")
	public void get_the_date_when_the_number_of_deaths_was_the_highest_and_the_count() throws Throwable {

		deathChains.getAllDeathNumbers(response);

		noDeathOutput = "The date when the number of deaths was the highest is '"
				+ deathChains.getMaxDeathDate(response) + "' and the count for that day rose by '"
				+ deathChains.getMaxDeathInADay(response) + "', while the total deaths on that day stood at '"
				+ deathChains.getMaxDeathNo(response) + "'";

	}

	@After
	public void TearDown() throws Exception {

		if (library.getResponseCode(response) == 200) {

			System.out.println(
					"---------------------------RESULT (Also present in TextReport/Result.txt)---------------------------");
			System.out.println("COVID19 stats for the country '" + ISO + "': ");
			System.out.println(noInfectionOutput);
			System.out.println(noDeathOutput);

			BufferedWriter bw = library.writeToTxt(configData.getTextPath());
			bw.write("COVID19 stats for the country '" + ISO + "': ");
			bw.newLine();
			bw.write(noInfectionOutput);
			bw.newLine();
			bw.write(noDeathOutput);
			bw.newLine();
			bw.close();
		}
	}

}