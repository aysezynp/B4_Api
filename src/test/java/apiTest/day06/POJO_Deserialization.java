package apiTest.day06;

import apiPOJOTemplates.PetStoreUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class POJO_Deserialization {
    @BeforeClass
    public void beforeClass(){
        baseURI="https://petstore.swagger.io/v2";

    }
    /**
     "id": 9223372036854776000,
     "username": "Miky",
     "firstName": "mike",
     "lastName": "masters",
     "email": "mike@gmail.com",
     "password": "Test1234",
     "phone": "55512345",
     "userStatus": 0
     */
 @Test
    public void oneUserPetStore(){
     Response response = given().accept(ContentType.JSON)
             .and()
             .pathParam("username", "Miky")
             .when()
             .get("/user/{username}");

     System.out.println("response.statusCode() = " + response.statusCode());

     //JSON to our petStore object
     PetStoreUser oneUser=response.body().as(PetStoreUser.class);

     //print all information
     System.out.println("oneUser.getId() = " + oneUser.getId());
     System.out.println("oneUser.getUserStatus() = " + oneUser.getUserStatus());
     System.out.println("oneUser.getFirstname() = " + oneUser.getFirstname());
     System.out.println("oneUser.getEmail() = " + oneUser.getEmail());
     System.out.println("oneUser.getLastname() = " + oneUser.getLastname());
     System.out.println("oneUser.getPhone() = " + oneUser.getPhone());

     //verify all information
     Assert.assertEquals(oneUser.getId(),"9223372036854776000");
     Assert.assertEquals(oneUser.getUserStatus(),22);
     Assert.assertEquals(oneUser.getFirstname(),"mike");
     Assert.assertEquals(oneUser.getEmail(),"mike@gmail.com");
     Assert.assertEquals(oneUser.getLastname(),"masters");
     Assert.assertEquals(oneUser.getPhone(),"55512345");

 }

}
