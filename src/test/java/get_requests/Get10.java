package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import jdk.jfr.Threshold;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get10 extends GoRestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/13
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
         {
    "meta": null,
    "data": {
        "id": 13,
        "name": "Suresh Johar",
        "email": "suresh_johar@von-damore.biz",
        "gender": "female",
        "status": "active"
    }
}
     */
@Test
    public void get10(){
    spec.pathParams("first", "users", "second",13);

    // set the expected Data
    // first create this map in our test Data class. then here we use it
    GoRestTestData obj = new GoRestTestData();
    Map<String,String> goRestDataMap= obj.goRestDataMap("Suresh Johar","suresh_johar@von-damore.biz","female","active");
    Map<String, Object> expectedData = obj.expectedDataMapSetup(null, goRestDataMap);
    System.out.println("expectedData=" + expectedData);

    Response response = given().spec(spec).when().get("/{first}/{second}");
    response.prettyPrint();

    // Do Assertion
    Map<String,Object> actualData = response.as(HashMap.class);
    System.out.println("actualData=" + actualData);

    assertEquals(200,response.statusCode());
    assertEquals(expectedData.get("meta"),actualData.get("meta"));
    assertEquals(goRestDataMap.get("name"),((Map)(actualData.get("data"))).get("name"));
    assertEquals(goRestDataMap.get("email"),((Map)(actualData.get("data"))).get("email"));
    assertEquals(goRestDataMap.get("gender"),((Map)(actualData.get("data"))).get("gender"));
    assertEquals(goRestDataMap.get("status"),((Map)(actualData.get("data"))).get("status"));

}


}
