package delete_request;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;                               ////Delete In Postman////
import org.junit.Test;                           // when we tried to delete the URL in POSTMAN gave us 403 with "forbidden" message
                                                 //which means we do not have Authorization to delete it. so we need to get Token,we copy the URL
import static io.restassured.RestAssured.given;  //and go their website and read documention how to delete it, then back to postman and do all
import static org.junit.Assert.assertEquals;     // for get token in postman : get url in website =>copy and chose post ==>Authorization
import static utils.AuthenticationHerOkuApp.generateToken;      //==>then "Bearer Token" then press "send " gives you Token

public class Delete02 extends HerOkuAppBaseUrl {
/*
    Given
        https://restful-booker.herokuapp.com/booking/{bookingId} //when you copy this in Postman, take {} off and add random data number
    When
	 	I send DELETE Request to the Url
	Then
		Status code is 200

		And Response body is "Created"
     */

@Test
    public void delete02(){
//Set the Url
spec.pathParams("first","booking","second",4358);

//Set the expectedData  ==> we are expecting String Value which is "Created"
String expectedData = "Created";

// send the Req and get Res==>
Response response = given().
spec(spec).header("Cookie", "token"+generateToken()).//New class in Util for this as AuthenticationHerOkuApp create METHOD there and call it here
           contentType(ContentType.JSON).
              when().delete("/{first}/{second}");
response.prettyPrint();

// Do Assertion

    assertEquals(201,response.statusCode());
    assertEquals(expectedData,response.asString());
}

}
