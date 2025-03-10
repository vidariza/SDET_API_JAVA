package com.unosquare;

import org.testng.annotations.Test;
import org.testng.Reporter;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TESTGWT {

    @Test
    public void validateFirstUrl() {
       
        Response response = given()
            .when()
            .get("https://reqres.in/api/users/2");

     
        System.out.println(response.asString());

        // Perform assertions on the response
        response.then()
            .assertThat()
            .statusCode(200)
            .and()
            .body("data.id", equalTo(2))
            .body("data.email", equalTo("janet.weaver@reqres.in"))
            .body("data.first_name", equalTo("Janet"))
            .body("data.last_name", equalTo("Weaver"))
            .body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"))
            .body("support.url", equalTo("https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral"))
            .body("support.text", equalTo("Tired of writing endless social media content? Let Content Caddy generate it for you."));

        Reporter.log("Successfully validated the first URL");
    }
}

