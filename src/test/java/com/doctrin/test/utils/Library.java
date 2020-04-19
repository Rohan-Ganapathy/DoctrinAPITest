package com.doctrin.test.utils;

import static io.restassured.RestAssured.given;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import com.doctrin.test.config.ConfigData;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * Bunch of common utils that can be used through out the framework
 * @author Rohan Ganapathy
 *
 */
public class Library {
	
    public static int maxConfirmed;
    public static int maxDay;
    public static int totalConfirmed;
    BufferedWriter bw;
    
    ConfigData configData = new ConfigData();
   
    public Library(int maxConfirmed, int totalConfirmed, int idex) {
   
        Library.maxConfirmed = maxConfirmed;
        Library.maxDay = idex;
        Library.totalConfirmed = totalConfirmed;
    }
	
	public Library() {
		
	}

	public Response getResponse(String URL, String getParam, String countryISO) throws Exception {
		Response response = null;
		
		this.bw = writeToTxt(configData.getTextPath());
			
			try {
				RestAssured.baseURI = URL;
				response=given().get(getParam+countryISO);
				
	            if (!(getResponseCode(response)==200)) {
	            	System.out.println("---------------------------Status code---------------------------");
		            System.out.println("Status code: "+getResponseCode(response));
		            
		            bw.write("---------------------------Status code---------------------------");
		            bw.newLine();
		            bw.write("Status code: "+getResponseCode(response));
		            bw.newLine();
		            
	            	throw new Exception();
	            }
				
			} catch (Exception e){
				System.out.println("---------------------------Error Message---------------------------");
				System.out.println("Message: Please check if '"+countryISO+"' is a valid country ISO2 code or check if the URL is correct and is valid");
				System.out.println("Request URI: "+RestAssured.baseURI + getParam+countryISO);
				System.out.println("---------------------------Exception---------------------------");
				System.out.println(e);
				
				bw.write("---------------------------Error Message---------------------------");
	            bw.newLine();
	            bw.write("Message: Please check if '"+countryISO+"' is a valid country ISO2 code or check if the URL is correct or is working");
	            bw.newLine();
	            bw.write("Request URI: "+RestAssured.baseURI + getParam+countryISO);
	            bw.newLine();
	            bw.write("---------------------------Exception---------------------------");
	            bw.newLine();
	            bw.write(e.toString());
	            bw.newLine();
	            bw.close();
			}
			return response;		
	}
	
	public String getResponseAsString(Response response) {
		
		return response.then().extract().response().asString();
		
	}
	
	public String getResponseHeaders(Response response) {
		
		return response.then().extract().response().getHeaders().asList().toString();
		
	}
	
	public int getResponseCode(Response response) {
		
		return response.then().extract().response().statusCode();
		
	}
	
	
	public JsonPath getJsonPath(Response response) {
		JsonPath js = new JsonPath(response.asString());
		return js;
	}
	
	public int[] getJsonPathValueArray(JsonPath js, String jsonPath) {

		int count=js.getInt(jsonPath+".size");
		
		int[] confirmedArray = new int[count];
		for (int i = 0; i < count; i++) {
		    int confirmedCase = js.get(jsonPath+"["+i+"]");
		    confirmedArray[i] = confirmedCase;
		}
		
		return confirmedArray;
		
	}
	
	public Library getData(int[] array){

		int diff = 0;

	    int max = 0;
	    int total = 0;
	    int idex = 0;
	    for (int i = 0; i < array.length-1; ++i){

	        diff = Math.abs(array[i] - array[i+1]);
	        if(max < diff) {
	            max = diff;
	            total = array[i+1];
	            idex = i+1;
	        	
	        }
	    }

	    return new Library(max, total, idex);
   }
	
	public int getMaxNo() {
		return maxConfirmed;
	}
	
	public int getMaxDay() {
		return maxDay;
	}
	
	public int getMaxTotal() {
		return totalConfirmed;
	}
	
	public BufferedWriter writeToTxt(String fileName) throws IOException {
		File fout = new File(fileName);
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		return bw;

	}

}
