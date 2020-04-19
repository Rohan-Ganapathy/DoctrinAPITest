package com.doctrin.test.actionchains;

import com.doctrin.test.config.ConfigData;
import com.doctrin.test.utils.Library;
import io.restassured.response.Response;

public class CommonChains {
	
	public Response response;

	Library library = new Library();
	ConfigData configData = new ConfigData();
	
	public Response accessAPI(String countryISO) throws Exception {

		response = library.getResponse(configData.getAPILink(), configData.getGetLink(), countryISO);

		return response;

	}
	

}
