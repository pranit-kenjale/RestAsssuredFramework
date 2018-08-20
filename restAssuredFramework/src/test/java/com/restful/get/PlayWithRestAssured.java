package com.restful.get;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

//import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PlayWithRestAssured {

	@Test(enabled=false)
	public void testGetWeatherData() {
	
/*	Response response = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	int code = response.getStatusCode();
	System.out.println("\nStatus code is: " + code);
	System.out.println("\nResponse time is: " + response.timeIn(TimeUnit.SECONDS) + " seconds OR " + response.time() + " milliseconds!");
	
	Assert.assertEquals(code, 200);*/
		
	//get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
}
	

	@Test	//(enabled=false)
	public void testGetMethod() {	//Get - http://httpbin.org/get
	String jsonString = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").asString();
	
	System.out.println("\nBody: " + jsonString);
		
		JsonPath jp = new JsonPath(jsonString);
		//jp.setRoot("weather");
		
		System.out.println("\nJSON - id - " + jp.getInt("id"));
		Assert.assertEquals(jp.getInt("id"), 2643743, "id does not match!");
		
		System.out.println("\nJSON - Name - " + jp.get("name"));
		Assert.assertEquals(jp.get("name"), "London", "Name does not match!");
		
		
		System.out.println("\nJSON - main.humidity - " + jp.get("main.humidity"));
	}
	
	@Test
	public void testPostMethod() {

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		
		JSONObject json= new JSONObject();
		json.put("id", 6199);
		json.put("slash", "chuspa");
		json.put("milton", "thermosteel");
		
		request.body(json.toJSONString());
		Response response = request.post("http://httpbin.org/post"); //Delete - http://httpbin.org/delete
		int code = response.getStatusCode();
		System.out.println("\nPOST METHOD \n\nReponse body: " + response.asString());
		Assert.assertEquals(code, 200);
	}
	
	@Test
	public void testPutMethod() {

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		
		JSONObject json= new JSONObject();
		json.put("origin", "127.0.0.1");
		json.put("url", "www.slash.com");
		
		request.body(json.toJSONString());
		Response response = request.put("http://httpbin.org/put");
		int code = response.getStatusCode();
		System.out.println("\nPUT METHOD \n\nReponse body: " + response.asString());
		Assert.assertEquals(code, 200);
	}
	
	@Test
	public void testDeleteMethod() {

		RequestSpecification request = RestAssured.given();
		Response response = request.delete("http://httpbin.org/delete");
		int code = response.getStatusCode();
		System.out.println("\nDELETE METHOD \n\nResponse body: " + response.asString());
		Assert.assertEquals(code, 200);
	}
}
