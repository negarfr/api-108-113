package hw;

import base_urls.RegresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Hw1 extends RegresBaseUrl {
   /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */
@Test
    public void hw1(){
    //set the url
    spec.pathParams("first","users", "second",3);

    // Send the request to get response
    Response response = given().spec(spec).when().get("/{first}/{second}");
    response.prettyPrint();

// do assertion
    response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");




}




}
