package apiTest.day3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class UserGetRequestWithQueryParam {
    @BeforeClass
    public void beforeClass(){
        baseURI="https://www.krafttechexlab.com/sw/api/v1";

    }
    /**
        TASK
        Given accept type json
        And query  parameter value name Thomas Eduson
        And query  parameter value skills Cypress
        And query  parameter value pagesize 50
        And query  parameter value page 1
        When user sends GET request to /allusers/alluser
        Then response status code should be 200
        And response content-type "application/json; charset=UTF-8"
        And response body contains "Developer" message

         */
    @Test
    public void queryParam() {
        Response response = given().accept(ContentType.JSON)
                .and()
                .queryParam("name", "Thomas Eduson")
                .queryParam("skills", "Cypress")
                .queryParam("pagesize", 50)
                .queryParam("page", 1)
                .when().log().all()                 //gönderdiğimiz requestin body sini veriyor.
                .get("/allusers/alluser");

        //verify status code
        assertEquals(response.statusCode(),200);

        //verify content type
        assertEquals(response.header("Content-Type"),"application/json; charset=UTF-8");
        //2.yol
        assertEquals(response.contentType(),"application/json; charset=UTF-8");

        //verify body contains "Developer" message
        assertTrue(response.body().asString().contains("Developer"));

    }

    @Test
    public void requestWithMap1(){
        Map<String,Object>mapBody=new HashMap<>();
        mapBody.put("name","Thomas Eduson");
        mapBody.put("skills","Cypress");
        mapBody.put("pagesize",50);
        mapBody.put("page",1);

        Response response = given().accept(ContentType.JSON)
                .and()
                .queryParams(mapBody)
                .when().log().all()
                .get("/allusers/alluser");

        assertEquals(response.statusCode(),200);

    }
}
