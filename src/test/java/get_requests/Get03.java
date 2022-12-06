package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get03 extends JsonPlaceHolderBaseUrl {
 /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be “application/json”
		And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		And
		    “completed” is false
		And
		    “userId” is 2
     */
    @Test

    public void get03(){

    //1- set the url- here we are going to put this base url and use in another class- look at Json class

    spec.pathParams("first","todos","second",23); //spec came from url holder we create for URL
            // .pathParams() means I will add my parameters into my base URl, name of the parameters in there

    //2- set the expected data - ( we do this later )

    //3- Send the request and get the response

    Response response= given().spec(spec).when().get("/{first}/{second}"); // get first and second parameters from end point
    response.prettyPrint();

    // 4- Do assertion
        // A- 1st WAY :
        response.then().assertThat().statusCode(200).contentType("application/json").
        body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).// use body
        body("userId",equalTo(2)). // use body() to reach the Data inside the body
        body("completed",equalTo(false)); // use equalTo() we test if they are equal or not


    // B- 2nd Way : Soft Assertion
        // to do soft assertion you should do all value in one body method


    response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
   body("UserId",equalTo(3),"title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
           "completed",equalTo(true));

    /*
    NOte 1 : When you execute assertion, Java stops execution after the first failure.
    it means, assertion after failure were not executed.
    But the assertion before the failure were passed, because the assertion before the failure were executed.

   Note 2: If you type your code as execution will stop after the failure, it is called "Hard Assertion".
   Note 3: If you type your code as execution will not stop after the failure, it is called "Soft Assertion".
   Note 4: If you use multiple "body()" method it will work like "Hard Assertion"
   If you use one single "body()" method with multiple assertions it will work like "Soft Assertion"

     */





    }



}
