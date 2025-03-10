package com.unosquare;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TESTHTTP2 {
  @Test
  public void f() {
	   
	    RestAssured.baseURI = "https://reqres.in/api/";
	    RequestSpecification httpRequest = RestAssured.given();
	    Response response = httpRequest.get("/unknown/2");

	    int statusCode = response.getStatusCode();
	    int id = response.jsonPath().getInt("data.id");
	    String name = response.jsonPath().getString("data.name");
	    int year = response.jsonPath().getInt("data.year");
	    String color = response.jsonPath().getString("data.color");
	    String pantoneValue = response.jsonPath().getString("data.pantone_value");

	    // Assertions to validate the response
	    Assert.assertEquals(statusCode, 200);
	    Assert.assertEquals(id, 2);
	    Assert.assertEquals(name, "fuchsia rose");
	    Assert.assertEquals(year, 2001);
	    Assert.assertEquals(color, "#C74375");
	    Assert.assertEquals(pantoneValue, "17-2031");

	    // Logging the success message
	    Reporter.log("Success 200 validation and data validation for unknown resource");
	}
  }
