package com.unosquare;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.Reporter;

public class TestHTTP {
  @Test
  public void f() {
    
      RestAssured.baseURI = "https://reqres.in/api/";
      RequestSpecification httpRequest = RestAssured.given();
      Response response = httpRequest.get("/users/2");

      int statusCode = response.getStatusCode();
      String email = response.jsonPath().getString("data.email");
      String firstName = response.jsonPath().getString("data.first_name");
      String lastName = response.jsonPath().getString("data.last_name");
      String avatar = response.jsonPath().getString("data.avatar");

      // Assertions to validate the response
      Assert.assertEquals(statusCode, 200);
      Assert.assertEquals(email, "janet.weaver@reqres.in");
      Assert.assertEquals(firstName, "Janet");
      Assert.assertEquals(lastName, "Weaver");
      Assert.assertEquals(avatar, "https://reqres.in/img/faces/2-image.jpg");

      // Logging the success message
      Reporter.log("Success 200 validation and data validation");
  }

}
