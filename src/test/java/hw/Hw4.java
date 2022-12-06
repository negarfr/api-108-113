package hw;
import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import io.restassured.specification.Argument;
import org.junit.Test;

import java.util.List;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Hw4 extends HerOkuAppBaseUrl {
//Homework4:
 /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Brandon&lastname=Wilson
        When
            User sends get request to the URL
        Then
            Status code is 200
        And
           Among the data there should be someone whose firstname is "Brandon" and lastname is "Wilson"
 */

    // " ? " in URL means end of URL and anything after ? calls "KEY" & "VALUE"
    // and in Set URL we need add queryParams() just like below example
@Test
    public void hw (){
    spec.pathParam("first","booking").queryParams("firstname","Brandon" ,"lastname", "Wilson");

    Response response = given().spec(spec).when().get("/{first}");
    response.prettyPrint();

    assertEquals(200,response.statusCode());
    assertTrue(response.asString().contains("bookingid"));


}


}
