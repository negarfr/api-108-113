package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationGMIBank {

    public static void main(String[] args) {
        System.out.println("generateToken()");  // we want to call it from other classes
    }

    public static String generateToken(){ // creTE METHOD

        Map<String, Object> map = new HashMap<>();
        map.put("password","John.123");
        map.put("rememberMe",true);
        map.put("username","john_doe");

        Response response = given().contentType(ContentType.JSON).body(map).when().post("https://www.gmibank.com//api/authenticate");

        return response.jsonPath().getString("id_token");
    }

/*
this is our Token from POSTMAN we return it with : response.jsonPath().getString("id_token");

    "id_token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huX2RvZSIsImF1dGgiOiJST0xFX0FETUlOIiwiZXhwIjoxNjcyMzI5NTM1fQ.8Ofa9yaEqKUp1zBfim_sdQIpUqP--PzQ-8c85OMP8eSN9XoTDWk9EjzythCsF2mjogfwpDwkmewvjTkvU9fXFg"
}
 */
}


/*
{
  "password": "John.123",
  "rememberMe": true,
  "username": "john_doe"
}

 */