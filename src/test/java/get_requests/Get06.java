package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get06 extends HerOkuAppBaseUrl {

/*
        Given
            https://restful-booker.herokuapp.com/booking/21
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
                {
                "firstname": "Mark",
                "lastname": "Jackson",
                "totalprice": 554,
                "depositpaid": True,
                "bookingdates": {
                    "checkin": "2018-01-01",
                    "checkout": ""2019-01-01""
                },
                "additionalneeds": "Breakfast"
                }
     */

@Test
        public void get06() {

    // Set the url
    spec.pathParams("first","booking","second",32);

    // expected data

    // send request and Get
  Response response = given().spec(spec).when().get("/{first}/{second}");
    response.prettyPrint();

    // Assertion
    // 1st Way
    response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
        body("firstname",equalTo("James"),
                "lastname",equalTo("Brown"),"totalprice",equalTo(111),"depositpaid",
                equalTo(true),
                "bookingdates.checkin",equalTo("2018-01-01"),
                "bookingdates.checkout", equalTo("2019-01-01"),
            "additionalneeds",equalTo("Breakfast"));

        //2nd Way : we will  use JsonPath Class

    JsonPath jsonPath =  response.jsonPath(); // we are able to exctract the data with Jason path

   assertEquals("James",jsonPath.getString("firstname")); // assertEquals is for assertion for inside the
   assertEquals("Brown",jsonPath.getString("lastname"));
   assertEquals("111",jsonPath.getInt("totalprice"));
   assertEquals("true",jsonPath.getBoolean("depositpaid"));
   assertEquals("2018-01-01",jsonPath.getString("bookingdates.checkin"));
   assertEquals("2019-01-01",jsonPath.getString("bookingdates.checkout"));
   assertEquals("Breakfast",jsonPath.getString("additionalneeds"));

    // soft Assertion
    //to do soft Assertion need to do three steps :
    // 1- create SoftAssert Object

    SoftAssert softAssert = new SoftAssert(); // create soft Assertion object

  // 2nd ; Use Assertion
    softAssert.assertEquals(jsonPath.getString("firstname"),"James","firstname did not match");
    softAssert.assertEquals(jsonPath.getString("lastname"),"Brown","lastname did not match");
    softAssert.assertEquals(jsonPath.getInt("totalprice"),111,"totalprice did not match");
    softAssert.assertEquals(jsonPath.getBoolean("depositpaid"),true,"depositpaid did not match");
    softAssert.assertEquals(jsonPath.getString("totalprice"),111,"totalprice did not match");
    softAssert.assertEquals(jsonPath.getString("bookingdates.checkin"),"2018-01-01","checkin did not match");
    softAssert.assertEquals(jsonPath.getString("bookingdates.checkout"),"2019-01-01","checkout did not match");
    softAssert.assertEquals(jsonPath.getString("additionalneeds"),"breakfast","additionalneeds did not match");



  //3rd : Use assertAll() method
    softAssert.assertAll(); // this part is very importNT







}


}
