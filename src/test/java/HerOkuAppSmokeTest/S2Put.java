package HerOkuAppSmokeTest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.JsonUtils;

import static HerOkuAppSmokeTest.S1Post.bookingid;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utils.AuthenticationHerOkuApp.generateToken;

public class S2Put extends HerOkuAppBaseUrl {
        /*
        Given

        And
                   {
                    "fi https://restful-booker.herokuapp.com/booking/:idrstname" : "Josef",
                    "lastname" : "Brown",
                    "totalprice" : 111,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2018-01-01",
                        "checkout" : "2019-01-01"
                    },
                    "additionalneeds" : "Breakfast"
                        }
        When
          User send Put request
        Then
          Status Code is 200
        And
          Response body should be like
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
    public void put01(){
// set the URL

//spec.pathParams("first","booking","second", bookingid); // for this bookingid look in S1Post class right on top and bottom
//
//// Set expectedData
//BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2022-11-27","2022-11-29");
//BookingPojo expectedData = new BookingPojo("James","Brown",500,false,bookingDatesPojo,"Breakfast");
//System.out.println("expectedData=" + expectedData);
//
////Send the request and get the response
//Response response = given().
//        spec(spec).
//        contentType(ContentType.JSON).
//        headers("Cookie","token="+generateToken()).
//        body(expectedData).
//        when().
//        put("/{first}/{second}");
//response.prettyPrint();
//
//// Do Assertion convert our response with objectMapper, We assert this part just like what we did in S1Post class
//BookingPojo actualData = JsonUtils.convertJsonToJavaObject(response.asString(),BookingPojo.class);
//System.out.println("actualData = " + actualData);
//assertEquals(200,response.statusCode());
//assertEquals(expectedData.getFirstname(),actualData.getFirstname());
//assertEquals(expectedData.getLastname(),actualData.getLastname());
//assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
//assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
//assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());
//
//assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingdates().getCheckin());
//assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());
}
 //when you run you must run from the package becasue first need to run the post class then this one otherwise you get error


}
