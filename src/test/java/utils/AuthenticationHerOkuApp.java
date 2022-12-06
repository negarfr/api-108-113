package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationHerOkuApp {   // this class is for create TOEKN

    public static void main(String[] args) {
      System.out.println(generateToken()); // at the end to call this Method other classes for Token
    }
    public static String generateToken() {

    // to create token we need to send "POST REQUEST" just like in Postman, then we need URL and put the body in Map

        // first, we need the add our URL as String
   String url = "https://restful-booker.herokuapp.com/auth"; // From the documentation we get this URL

        // Third, Need to crate Map for Body
   Map<String, String> postBody = new HashMap<>(); // for body()
   postBody.put("username","admin");
   postBody.put("password" , "password123");

        // second, we write the response request
   Response response =  given().contentType(ContentType.JSON).body(postBody).when().post(url);


   return response.jsonPath().getString("token"); // To get only TOKEN we use jsonPath()
                                                      //then top page we call the method we be able to get it from all classes
    }



















/*
the body form website
{
    "username" : "admin",
    "password" : "password123"
}
 */



}
