package apiTest.day07;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class PostRequestDemo {

    @BeforeClass
    public void beforeClass() {
        baseURI="https://www.krafttechexlab.com/sw/api/v1";
    }

    @Test
    public void postNewUser() {

        String jsonBody="{\n" +
                "  \"name\": \"aysex\",\n" +//burda her test yapışında giriş bilgilerini yenilemeyi unutma!
                "  \"email\": \"aysex@kraftexlab.com\",\n" +
                "  \"password\": \"Test1234\",\n" +
                "  \"about\": \"About Me\",\n" +
                "  \"terms\": \"10\"\n" +
                "}";

        Response response = given().accept(ContentType.JSON) // hey api send me body as json format
                .and()
                .contentType(ContentType.JSON) //hey api I am sending json body
                .and()
                .body(jsonBody)
                .when()
                .post("/allusers/register");
        assertEquals(response.statusCode(),200);
        response.prettyPrint();
        assertTrue(response.body().asString().contains("token"));
    }

    @Test
    public void postNewUser2() {
        Map<String,Object>requestMap=new HashMap<>();
        requestMap.put("name","sebastian");
        requestMap.put("email","sebastian8@kraftexlab.com");
        requestMap.put("password","Test1234");
        requestMap.put("about","About me");
        requestMap.put("terms","5");

        Response response = given().accept(ContentType.JSON) // hey api send me body as json format
                .and()
                .contentType(ContentType.JSON) //hey api I am sending json body
                .and()
                .body(requestMap)
                .when()
                .post("/allusers/register");

        assertEquals(response.statusCode(),200);
        response.prettyPrint();
        assertTrue(response.body().asString().contains("token"));
    }

    @Test
    public void postNewUser3() {
        NewUSerInfo newUSerInfo=new NewUSerInfo();
        newUSerInfo.setName("aysexyzt");
        newUSerInfo.setEmail("aysexyt6@kraftexlab.com");
        newUSerInfo.setPassword("Test1234");
        newUSerInfo.setAbout("About me");
        newUSerInfo.setTerms("5");

        Response response = given().accept(ContentType.JSON) // hey api send me body as json format
                .and()
                .contentType(ContentType.JSON) //hey api I am sending json body
                .and()
                .body(newUSerInfo)// serialization
                .when()
                .post("/allusers/register");

        assertEquals(response.statusCode(),200);
        response.prettyPrint();
        assertTrue(response.body().asString().contains("token"));
    }
    @Test
    public void postNewUser4() {
        NewUSerInfo newUSerInfo=new NewUSerInfo("Lost","lost@krafttechexlab.com","Test1234","About me","5");

        Response response = given().accept(ContentType.JSON) // hey api send me body as json format
                .and()
                .contentType(ContentType.JSON) //hey api I am sending json body
                .and()
                .body(newUSerInfo)// serialization
                .when()
                .post("/allusers/register");

        assertEquals(response.statusCode(),200);
        response.prettyPrint();
        assertTrue(response.body().asString().contains("token"));
    }
}
