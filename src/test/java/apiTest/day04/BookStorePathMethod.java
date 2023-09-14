package apiTest.day04;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;



public class BookStorePathMethod {
    @Test
    public void bookStoreGetTest(){
        Response response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Books" );

        //verify status code
        Assert.assertEquals(response.statusCode(),200);

        //verify content type
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");

        //verify that isbn number of the first book
        String expectedIsbnNumber="9781449325862";
        String actualIsbnNumber=response.path("books.isbn[0]")+"";
        Assert.assertEquals(actualIsbnNumber,expectedIsbnNumber);

        //verify that publisher of the first book
        String expectedPublisher="O'Reilly Media";
        String actualPublisher=response.path("books.publisher[0]");
        Assert.assertEquals(actualPublisher,expectedPublisher);

    }





}
