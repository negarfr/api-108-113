package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get02 {

        /*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void get02() {

        //1-  set the url
        String url = " https://restful-booker.herokuapp.com/booking/0";
        //2-  set the expected data     ( we do this later )

        // 3- Send the request and get the respond
        Response response = given().when().get(url);
        response.prettyPrint();

        // Do Assortion

        response.then().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        //How to assert if response body contains any data
        //Response body contains "Not Found"
        //assertTrue(x) method passes if x is true
        assertTrue(response.asString().contains("Not Found"));  // for the part in Task asking :Response body contains "Not Found"

        //Response body does not contain "TechProEd"
        //assertFalse(x) method passes if x is false

        //Response body does not contain "TechProEd"
        //assertFalse(x) method passes if x is false
        assertFalse(response.asString().contains("TechProEd"));

        //   Server is "Cowboy" :
        // how to assert this part

        assertEquals("Cowboy",response.getHeader("Server"));

    }


}
