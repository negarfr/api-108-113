package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerOkuAppBaseUrl {
/*
        Given
            https://restful-booker.herokuapp.com/booking/246
        When
            I send GET Request to the url
        Then
            Response body should be like that;
            {
                "firstname": "Howard",
                "lastname": "Liu",
                "totalprice": 111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2018-01-01",
                    "checkout": "2019-01-01"
                },
                "additionalneeds": "Breakfast"
            }
     */

@Test
        public void get09() {

    // set the url
    spec.pathParams("first", "booking", "second", 246);

    // 2- set expected data    to Compare with Actual Data

    Map<String, String> bookingDatesMap = new HashMap<>();// first we create empty map for inner data
    bookingDatesMap.put("checkin", "2018-01-01");// key and Value
    bookingDatesMap.put("checkout", "2019-01-01");// key & Value inside the parantes

    Map<String, Object> expectedData = new HashMap<>();
    expectedData.put("firstname", "Alex");
    expectedData.put("lastname", "Dominguez");
    expectedData.put("totalprice", "111");
    expectedData.put("depositpaid", true);
    expectedData.put("bookingdates", bookingDatesMap);
    expectedData.put("additionalneeds", "Breakfast");

    Response response = given().spec(spec).when().get("/{first}/{second}");
    response.prettyPrint();

    // Now Assertion ==> which is expected data and actual data comparing
// first :Deserialization
    Map<String, Object> actualData = response.as(HashMap.class);
    System.out.println("actualData=" + actualData);

    // second:  assertion
    assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
    assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
    assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
    assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));

    // 1st way
    assertEquals(((Map) expectedData.get("bookingdates")).get("checkin"), ((Map) (actualData.get("bookingdates"))).get("checkin"));
    //(((Map)expectedData.get("bookingdates")).get("checkin") ==. give us the check in date
    assertEquals(((Map) expectedData.get("bookingdates")).get("checkout"), ((Map) (actualData.get("bookingdates"))).get("checkout"));

    //2nd Way- Recommended way
    assertEquals(bookingDatesMap.get("checkin"), ((Map) (actualData.get("bookingdates"))).get("checkin"));
    assertEquals(bookingDatesMap.get("checkout"), ((Map) (actualData.get("bookingdates"))).get("checkout"));

}


    @Test
    public void get09b() {

        // 1- set the url
        spec.pathParams("first", "booking", "second", 246);

        // 2- set expected data    to Compare with Actual Data
     HerOkuAppTestData obj = new HerOkuAppTestData();
     Map<String, String> bookingDatesMap = obj.bookingdatesMapSetup("2018-01-01", "2019-01-01");

    Map<String,Object> expectedData = obj.expectedDataSetUp("Alex", "Dominguez",111,true,bookingDatesMap, "Breakfast");
        System.out.println("expectedData =" + expectedData);

        // 3- send the request and get response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Now Assertion ==> which is expected data and actual data comparing
// first :Deserialization
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData=" + actualData);

        // second:  assertion
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));

        // 1st way
        assertEquals(((Map) expectedData.get("bookingdates")).get("checkin"), ((Map) (actualData.get("bookingdates"))).get("checkin"));
        //(((Map)expectedData.get("bookingdates")).get("checkin") ==. give us the check in date
        assertEquals(((Map) expectedData.get("bookingdates")).get("checkout"), ((Map) (actualData.get("bookingdates"))).get("checkout"));

        //2nd Way- Recommended way
        assertEquals(bookingDatesMap.get("checkin"), ((Map) (actualData.get("bookingdates"))).get("checkin"));
        assertEquals(bookingDatesMap.get("checkout"), ((Map) (actualData.get("bookingdates"))).get("checkout"));


    }








    }
