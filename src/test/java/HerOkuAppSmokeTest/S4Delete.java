package HerOkuAppSmokeTest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static HerOkuAppSmokeTest.S1Post.bookingid;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utils.AuthenticationHerOkuApp.generateToken;

public class S4Delete extends HerOkuAppBaseUrl {
/*
Given
       https://restful-booker.herokuapp.com/booking/:id
When
        User send Delete request
Then
        status code is 201
And
       response body is "created"
 */

@Test
    public void delete01(){
// set the url

    spec.pathParams("first","booking","second",bookingid);

// set the expectedData
   String expectedData = "Created";
// send the Req and get Resquest and get response

    Response response = given().spec(spec).
            headers("Cookies","Token="+generateToken()).
            contentType(ContentType.JSON).when().delete("/{first}/{second}");
    response.prettyPrint();

    //Do Assertion
    assertEquals(200,response.statusCode());
    assertEquals(expectedData,response.asString());





}


}
