package apiTest.day05;

import com.beust.ah.A;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;

public class jsonToJava {
    String kraftBaseURL = "https://www.krafttechexlab.com/sw/api/v1";
    String bookStoreBaseURL="https://bookstore.toolsqa.com";

    @Test
    public void putAllUsersToList() {
/**
 given accept type is JSON
 And query param pagesize is 50
 And query param page is 1
 When user sends a get request to /allusers/alluser
 Then status code 200
 put all response body inside a list by as() method
 make several verifications
 */
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("page", 1)
                .queryParam("pagesize", 50)
                .when()
                .get(kraftBaseURL + "/allusers/alluser");

        Assert.assertEquals(response.statusCode(), 200);

        //put all data inside the json body into a list of map
        //de-serilization
        //convert json body to java collection

        List<Map<String, Object>> allUSer = response.as(List.class);

        //verify that the email of first user is "afmercan@gmail.com"
        String actualEmail = (String) allUSer.get(0).get("email");
        String expectedEmail = "afmercan@gmail.com";
        Assert.assertEquals(expectedEmail, actualEmail);

        //verify that job of first user is "Manual Tester"
        String actualJob = (String) allUSer.get(0).get("job");
        String expectedJob = "Manual Tester";
        Assert.assertEquals(actualJob, expectedJob);

        //verify that second skill of first user is "Java"
        List<String> skills = (List<String>) allUSer.get(0).get("skills");
        String actualSkill = skills.get(1);
        String expectedSkill = "Java";
        Assert.assertEquals(actualSkill, expectedSkill);

        //verify that the third job of experience of the first user is "Junior Developer"
        List<Map<String, Object>> experience = (List<Map<String, Object>>) allUSer.get(0).get("experience");
        String actualJobOfExperience = (String) experience.get(2).get("job");
        String expectedJobOfExperience = "Junior Developer";
        Assert.assertEquals(actualJobOfExperience, expectedJobOfExperience);

    }

    @Test
    public void BookStoreUserTest_NegativeCase() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(bookStoreBaseURL + "/Account/v1/User/1");

        //verify status code
        Assert.assertEquals(response.statusCode(),401);

        //put all data inside the json body into a java collection
        // de-serialization

        Map<String,Object>map=response.as(Map.class);
        String actualCode= (String) map.get("code");
        String expectedCode="1200";
        Assert.assertEquals(actualCode,expectedCode);

        //verify that message is user not authorized
        String actualMessage= (String) map.get("message");
        String expectedMessage="User not authorized!";
        Assert.assertEquals(actualMessage,expectedMessage);



    }


}
