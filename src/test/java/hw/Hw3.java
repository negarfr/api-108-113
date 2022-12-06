package hw;

import base_urls.RegresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Hw3 extends RegresBaseUrl {
//Homework3:
    /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “email” is “janet.weaver@reqres.in”,
       And
           “first_name” is "Janet"
       And
           “last_name” is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */
@Test
    public void hw3() {
    // set URL
    spec.pathParams("first", "users", "second", 2);

    //send request

    Response response = given().spec(spec).when().get("/{}/{}");
    response.prettyPrint();

    // Assertion
    response.then().assertThat().statusCode(200).contentType("application/json").
            body("email", equalTo("janet.weaver@regres.in"),
                    "first_name", equalTo("Janet"),
                    "last_name", equalTo("Weaver"),
                    "text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));





}

}


