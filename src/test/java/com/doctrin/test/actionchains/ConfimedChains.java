package com.doctrin.test.actionchains;

import com.doctrin.test.config.ConfigData;
import com.doctrin.test.utils.Library;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ConfimedChains {
	
	JsonPath js;
	
	Library library = new Library();
	ConfigData configData = new ConfigData();
	CommonChains commonChains = new CommonChains();
	
	public void getAllConfimedNumbers(Response response) {
		this.js = library.getJsonPath(response);
		int jsonPathValueArray[] = library.getJsonPathValueArray(js, "Confirmed");
		
		library.getData(jsonPathValueArray);
	}
	
	public int getMaxConfimedNo(Response response) {
		
		return library.getMaxTotal();
		
	}
	
	public String getMaxConfimedDate(Response response) {
		
		return js.get("Date["+library.getMaxDay()+"]");
		
	}
	
	public int getMaxConfimedInADay(Response response) {
		
		return library.getMaxNo();
		
	}
	
	

}
