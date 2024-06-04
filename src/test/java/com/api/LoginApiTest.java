package com.api;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class LoginApiTest implements BaseApi{
    @Test
    public void loginTest_positiveTest(){
        Assert.assertEquals(login().getStatusCode(), 200);
        Assert.assertNotNull(login().getHeader("X-Token"));
    }
    public static Response login(){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization",
                        "Basic YWxleG1lZHF3ZXJ0eTFAZ21haWwuY29tOlF3ZXJ0eTEyMyE=")
                .when()
                .post(HOST+"/account/en/v1/login");
    }
}
