package com.unosquare;

import org.testng.Reporter;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class TESTGWT2 {

    @Test

  public void validateSecondUrl() {
      given()
          .when()
              .get("https://reqres.in/api/unknown/2")
          .then()
              .assertThat()
                  .statusCode(200)
                  .body("data.id", equalTo(2))
                  .body("data.name", equalTo("fuchsia rose"))
                  .body("data.year", equalTo(2001))
                  .body("data.color", equalTo("#C74375"))
                  .body("data.pantone_value", equalTo("17-2031"));

      // Logging the success message
      Reporter.log("Success 200 validation and data validation for unknown resource");
  }
}

