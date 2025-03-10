package com.unosquare;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FirstapiTestHTTP2 {

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
        Assert.assertEquals(statusCode, 200, "Status code is not 200");
        Assert.assertEquals(id, 2, "ID is not 2");
        Assert.assertEquals(name, "fuchsia rose", "Name does not match");
        Assert.assertEquals(year, 2001, "Year does not match");
        Assert.assertEquals(color, "#C74375", "Color does not match");
        Assert.assertEquals(pantoneValue, "17-2031", "Pantone value does not match");

        // Logging the success message
        Reporter.log("Success 200 validation and data validation for unknown resource");
    }
}
