package apiTest.day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class deneme {
String petStoreURL="https://petstore.swagger.io/v2";
String bookCartURL="https://bookcart.azurewebsites.net";

    @Test
    public void basicGetRequest(){
        Response response = RestAssured.get(petStoreURL + "/store/inventory");
        System.out.println("response.statusCode() = " + response.statusCode());

    }
    @Test
    public void bbbb(){
   RestAssured.given()
           .accept(ContentType.JSON)
           .when()
           .get(petStoreURL + "/store/inventory")
           .then()
           .assertThat()
           .statusCode(200)
           .and()
           .contentType("application/json");

    }

}
