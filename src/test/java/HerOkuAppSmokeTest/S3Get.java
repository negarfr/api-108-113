package HerOkuAppSmokeTest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.JsonUtils;

import static HerOkuAppSmokeTest.S1Post.bookingid;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class S3Get extends HerOkuAppBaseUrl {
    /*
  Given
   https://restful-booker.herokuapp.com/booking/:id
  When
   User send get request
  Then
    Sattus code 200
  And
    Resposne body should be like
                                                // we copy this from PUt class because we have update it there
    {
                    "firstname": "James",
                    "lastname": "Brown",
                    "totalprice": 500,
                    "depositpaid": false,
                    "bookingdates": {
                        "checkin": "2022-11-27",
                        "checkout": "2022-11-29"
                    },
                    "additionalneeds": "Breakfast"
                }

     */

@Test
    public void get01(){

 // Set the URL
 spec.pathParams("first","booking","second",bookingid);

 // Set the expectedData
    BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2022-11-27","2022-11-29");
    BookingPojo expectedData = new BookingPojo("James","Brown",500,false,bookingDatesPojo,"Breakfast");
    System.out.println("expectedData=" + expectedData);
 // send request
    Response response = given().spec(spec).when().get("/{first}/{second}");
    response.prettyPrint();// if we run here do not see anything on page because "bookingid" up in set url is null to see Data we must run from the package

  // Do Assertion ==> we copy all from post or put
    BookingPojo actualData = JsonUtils.convertJsonToJavaObject(response.asString(),BookingPojo.class);
    System.out.println("actualData = " + actualData);
    assertEquals(200,response.statusCode());
    assertEquals(expectedData.getFirstname(),actualData.getFirstname());
    assertEquals(expectedData.getLastname(),actualData.getLastname());
    assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
    assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
    assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());

    assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingdates().getCheckin());
    assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());
}






}
