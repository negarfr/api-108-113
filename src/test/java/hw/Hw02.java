package hw;

import base_urls.RegresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Hw02 extends RegresBaseUrl {
    /*
       Given
           https://reqres.in/api/users/23
       When
           User send a GET Request to the url
       Then
           HTTP Status code should be 404
       And
           Status Line should be HTTP/1.1 404 Not Found
       And
           Server is "cloudflare"        this is how we do it ===> assertEquals("cloudflare",response.header("server))
       And
           Response body should be empty
    */

    @Test
    public void hw02(){

        spec.pathParams("first", "users", "second",23);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        assertEquals(404,response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found",response.statusLine());
        assertEquals("cloudflare",response.header("Server"));

        assertEquals(0,response.asString().replaceAll("[^A-Za-z0-9]","").length());
        //or
        assertEquals(0,response.as(HashMap.class).size());

    }

}
