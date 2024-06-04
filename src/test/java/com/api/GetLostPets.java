package com.api;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class GetLostPets implements BaseApi {
    @Test
    public void getLostPets_positiveTest(){
        Assert.assertEquals(GetLostPets().getStatusCode(), 200);
    }

    public static Response GetLostPets() {
        String xToken = "";
        Response responseLogin = LoginApiTest.login();
        if (responseLogin.getStatusCode() == 200) {
            xToken = LoginApiTest.login().getHeader("X-Token");
            return RestAssured.given()
                    .contentType(ContentType.JSON)
                    .header("X-Token", xToken)
                    .when()
                    .get(HOST + "/lostfound/en/v1/losts?currentPage=0");
        } else {
            System.out.println("Bad login -->" + responseLogin.getStatusCode());
            return null;
        }

    }
}
