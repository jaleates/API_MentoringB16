package com.mentoring_1;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utils.API_Calls;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static utils.API_Calls.Get;

public class InterviewTask {


    @Test
    public void capitalValidationTest(){
        RestAssured.baseURI="https://restcountries.com";
        RestAssured.basePath="v3.1/all";
        Response response= RestAssured.given().accept("application/json")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().response();

      List<Map<String,Object>> parsedResponse=response.as(new TypeRef<List<Map<String, Object>>>() {
        });
List<String> capital=new ArrayList<>();
String expectedCapital="Baghdad";
String actualCapital="";
      for(int i=0;i<parsedResponse.size();i++){
          Map<String,Object> outerMap=parsedResponse.get(i);
          Map<String,Object> innerMap=(Map<String, Object>) outerMap.get("name");
          if(innerMap.get("common").equals("Iraq")){
              System.out.println(outerMap.get("capital"));
capital=(List<String>)outerMap.get("capital");
actualCapital=capital.get(0);
              break;
          }
      }
        System.out.println(capital);
        System.out.println(actualCapital);
        Assert.assertEquals(expectedCapital,actualCapital);




    }


    @Test
    public void validateBreakingBadQuotes(){
        RestAssured.baseURI="https://api.breakingbadquotes.xyz";
        RestAssured.basePath="v1/quotes";
       Response response= Get("/20");
List<Map<String,Object>>  parsedResponse=response.as(new TypeRef<List<Map<String, Object>>>() {
});

for(int i=0;i<parsedResponse.size();i++){
    Map<String,Object> map=parsedResponse.get(i);
    if(map.get("author").equals("Jesse Pinkman")){
        System.out.println(map.get("quote"));
        System.out.println(map.get("author"));
    }
//    System.out.println(map.get("quote"));
//    System.out.println(map.get("author"));
}







    }

}
