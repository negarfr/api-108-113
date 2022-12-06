package HerOkuAppSmokeTest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static HerOkuAppSmokeTest.S1Post.bookingid;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class S5Get extends HerOkuAppBaseUrl { // this is the "NEGATIVE" Case TEST, sth we deleted it now we want to Get it
 /*
Given
    https://restful-booker.herokuapp.com/booking/:id
When
    User sends Get request
Then
    Status code is 404
And
    Response body is like "Not Found"
 */

 @Test
 public void get02(){

    // Set the URL
     spec.pathParams("first","booking","second",bookingid);

     // set the EcpectedData
     String expectedData = "Not Found";

     // send Request and get response
     Response response = given().spec(spec).when().get("/{first}/{second}");
     response.prettyPrint();
    // Assertion
     assertEquals(404,response.statusCode());
     assertEquals(expectedData,response.asString());


 }

}
