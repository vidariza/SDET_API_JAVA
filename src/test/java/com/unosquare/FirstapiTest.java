package com.unosquare;

import org.testng.annotations.Test;
import org.testng.Reporter;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class FirstapiTest {

    @Test
    public void validateFirstUrl() {
        given()
            .when()
            .get("https://reqres.in/api/users/2")
            .then()
            .assertThat()
            .statusCode(200)
            .and()
            .body("data.id", equalTo(2))
            .body("data.email", equalTo("janet.weaver@reqres.in"))
            .body("data.first_name", equalTo("Janet"))
            .body("data.last_name", equalTo("Weaver"))
            .body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"))
            .body("support.url", equalTo("https://reqres.in/#support-heading"))
            .body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

        Reporter.log("Successfully validated the first URL");
	
	}
}