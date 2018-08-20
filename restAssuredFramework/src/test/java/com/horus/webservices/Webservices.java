package com.horus.webservices;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Webservices {

	public static Response get(String URI) {
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		Response response = request.get(URI);
		return response;
	}
	
	public static Response post(String URI, String stringJSON) {
		RequestSpecification request = RestAssured.given().body(stringJSON);
		request.contentType(ContentType.JSON);
		Response response = request.post(URI);
		return response;
	}
	
	public static Response put(String URI, String stringJSON) {
		RequestSpecification request = RestAssured.given().body(stringJSON);
		request.contentType(ContentType.JSON);
		Response response = request.put(URI);
		return response;
	}
}
