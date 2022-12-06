package put_request;

import base_urls.DummyApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyApiDataPojo;
import pojos.DummyApiResponsePojo;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends DummyApiBaseUrl {      // put_requests means we are going to change the data
    /*
     URL: https://dummy.restapiexample.com/api/v1/update/21
       HTTP Request Method: PUT Request
       Request body: {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been added."
                    }
     */
//=========================== first need to check the Test Case for us as is asking  =================
    /*
Test case:
Given
    https://dummy.restapiexample.com/api/v1/update/21
And
    {
                    "employee_name": "Tom Hanks",
                    "employee_salary": 111111,
                    "employee_age": 23,
                    "profile_image": "Perfect image"
                 }
When
    User sends Put request
Then
    Status code is 200
And
    Response body should be like the following
                {
                    "status": "success",
                    "data": {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                    },
                    "message": "Successfully! Record has been added."
                }


 */
@Test
    public void put02(){
    // Set the Url
    spec.pathParams("first","update","second",21);
    //set the expected data
    //

DummyApiDataPojo expectedData = new DummyApiDataPojo("Tom Hanks", 111111,23,"Perfect image");
    DummyApiResponsePojo responsePojo = new DummyApiResponsePojo("success",expectedData,"Successfully! Record has been updated.");
    System.out.println("responsePojo = " + responsePojo);

    //Send the request and get the response
    Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().put("/{first}/{second}");
    response.prettyPrint();

    //Do assertion
    DummyApiResponsePojo actualData = JsonUtils.convertJsonToJavaObject(response.asString(),DummyApiResponsePojo.class);
    System.out.println("actualData = " + actualData);

    assertEquals(200,response.statusCode());
    assertEquals(responsePojo.getStatus(),actualData.getStatus());
    assertEquals(expectedData.getEmployee_name(),actualData.getData().getEmployee_name());
    assertEquals(expectedData.getEmployee_salary(),actualData.getData().getEmployee_salary());
    assertEquals(expectedData.getEmployee_age(),actualData.getData().getEmployee_age());
    assertEquals(expectedData.getProfile_image(),actualData.getData().getProfile_image());
    assertEquals(responsePojo.getMessage(),actualData.getMessage());
}








}









