package post_request;

import base_urls.DummyApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.DummyApiDataPojo;
import pojos.DummyApiResponsePojo;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Post05ObjectMapper extends DummyApiBaseUrl {
/*
URL: https://dummy.restapiexample.com/api/v1/create
HTTP Request Method: POST Request
Request body: {
           "employee_name": "Ali Can",
            "employee_salary": 111111,
            "employee_age": 23,
             "profile_image": "Perfect image"
                     }
Test Case: Type by using Gherkin Language   // because of this we have to try with Text
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 6344
                        },
                        "message": "Successfully! Record has been added."
                    }
     */
/*   This is what we have as given in the task :  this is our test case in Gorken language

Given
    https://dummy.restapiexample.com/api/v1/create
And
{
    "employee_name": "Ali Can",
    "employee_salary": 111111,
    "employee_age": 23,
    "profile_image": "Perfect image"
 }
 When
    User sends Post request
 Then
    Status code is 200
 And
    Response body should be like the following

                {
                    "status": "success",
                    "data": {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image",
                        "id": 6344
                    },
                    "message": "Successfully! Record has been added."
                }
 */

@Test
    public void post05() throws IOException {

    spec.pathParam("first","create");

// se the expected dats ==> need to create two pojo DummyApiDataPojo for inside body and DummyApiResponse for response Body Pojo
// we need object from DummyApiDataPojo class which we created from body and this will be our expectedData BECAUSE we want to post it that is why is expectedData
DummyApiDataPojo expectedData = new DummyApiDataPojo("Ali Can", 111111,23,"Perfect image");
                                                        //inside the parasites we put credential from the body we want to post

//send the request and get response
Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
                        // because we sending data we should say what content is and what Body
response.prettyPrint();

// Do Assertion  ==> De-Serialization
   // need to convert response body to Pojo class with ObjectMapper() ==> {
    //                    "status": "success",
    //                    "data": {
    //                        "employee_name": "Ali Can",
    //                        "employee_salary": 111111,
    //                        "employee_age": 23,
    //                        "profile_image": "Perfect image",
    //                        "id": 6344
    //                    },
    //                    "message": "Successfully! Record has been added."
    //                }

// need ActualData and we created form DummyreponsePojo with "ObjectMappr()

   DummyApiResponsePojo actualData = new ObjectMapper().readValue(response.asString(), DummyApiResponsePojo.class);
                                        //
    System.out.println("actualData ="+ actualData );

    assertEquals(200,response.statusCode());
    assertEquals("success",actualData.getStatus());//we dont have "success" in our expectedData so we add it direct
    assertEquals(expectedData.getEmployee_name(),actualData.getData().getEmployee_name());//for actualData need to go to GetData() then go to the method we wanted
    assertEquals(expectedData.getEmployee_salary(),actualData.getData().getEmployee_salary());
    assertEquals(expectedData.getEmployee_age(),actualData.getData().getEmployee_age());
    assertEquals(expectedData.getProfile_image(),actualData.getData().getProfile_image());
    assertEquals("Successfully! Record has been added.",actualData.getMessage());


// we use objectMapper to convert our response to pojo


}

}
