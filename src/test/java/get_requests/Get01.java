package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

// change the "given" here to "*" to get all data from resassured
public class Get01 {

/*
1) Postman is used for manual API testing.
2) We use Rest-Assured Library for API Automation Testing.
3) To type automation script follow the given steps:

a) Understand the requirement

b) Type test cases,  To type test cases We use 'Gherkin Language'
The keywords are
x) Given: It is for pre-conditions
y) When: It is for actions
z) Then: It is for outputs
t) And: It is for multiple given, when and then.

c) **Start to type Automation Script **
i) Set the URL
ii) Set the expected Data(Post-Put-Patch)
iii) Type code to send the Request
iv) Do Assertion
*/

/*
Given
https://restful-booker.herokuapp.com/booking/10
When
User sends a GET Request to the url
Then
HTTP Status Code should be 200
And
Content Type should be JSON
And
Status Line should be HTTP/1.1 200 OK
*/
@Test
public void get01(){   // create a method and always must be public

//1) set the URL
String url =  "https://restful-booker.herokuapp.com/booking/10";

//2) set the expected Data (do this late)


// 3) send the request and get the response, and then we put that data into response container

Response response=  given().when().get(url);
// to see it on console

response.prettyPrint();

// 4 ) Do Assertion
// HTTP Status Code should be 200
// content Type should be Json
response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

// how to print "status code " on the console
System.out.println("Status Code "+ response.statusCode());

// How to see or print "Content Type" on the console
System.out.println("Content Type"+ response.contentType());
// How to see or print "Status Line" on the console

System.out.println("Status Line"+ response.statusLine());

// How to print "Header" on the console
System.out.println(response.getHeader("Server")); // get one specific header
System.out.println("==============");
System.out.println(response.getHeaders()); // give all headers

//  how to print "Time"
System.out.println(response.getTime());
}
}
