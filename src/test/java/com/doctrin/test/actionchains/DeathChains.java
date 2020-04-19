package com.doctrin.test.actionchains;

import com.doctrin.test.config.ConfigData;
import com.doctrin.test.utils.Library;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeathChains {
	
	JsonPath js;
	
	Library library = new Library();
	ConfigData configData = new ConfigData();
	CommonChains commonChains = new CommonChains();
	
	public void getAllDeathNumbers(Response response) {
		this.js = library.getJsonPath(response);
		int jsonPathValueArray[] = library.getJsonPathValueArray(js, "Deaths");
		
		library.getData(jsonPathValueArray);
	}
	
	public int getMaxDeathNo(Response response) {
		
		return library.getMaxTotal();
		
	}
	
	public String getMaxDeathDate(Response response) {
		
		return js.get("Date["+library.getMaxDay()+"]");
		
	}
	
	public int getMaxDeathInADay(Response response) {
		
		return library.getMaxNo();
		
	}
	
	

}
