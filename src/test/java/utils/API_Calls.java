package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API_Calls {

    public static Response Get(){

       return RestAssured.given().accept("appliction/json")
                .when()
                .get()
                .then().statusCode(200)
                .extract().response();
    }

    public static Response Get(String endpoint){

        return RestAssured.given().accept("appliction/json")
                .when()
                .get(endpoint)
                .then().statusCode(200)
                .extract().response();
    }




}
