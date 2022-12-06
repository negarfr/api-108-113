package post_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonPlaceHolderBaseUrl {
        /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2)
        When
            I send POST Request to the Url{
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
              }
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */
// what is the biggest challenge in API : IS CONVERTING DATA TYPE

    // TO Convert Json to Java Object,

    @Test
    public void post01() {
        // set url
        spec.pathParam("first", "todos");

        //2-  set the expected data  :  HOW TO CREATE PAYLOAD (MAP)
        // it is going to be MAP ==>    Map <String,Object>
        //Going to convert this data to Java object    {
        //                                    "userId": 55,
        //                                    "title": "Tidy your room",
        //                                    "completed": false,}
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 55);
        expectedData.put("title", "Tidy your room");
        expectedData.put("completed", false);

        System.out.println("expectedData = " + expectedData);

        //send the request and get the response

        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();                // send Jason content Type and send ecpectedData as body

        // Do Assertion
        // to do the Assertion we need "expected Data" and "Actual Data" we are going to comapre these two  DATA
        // here are "expected Data" is MAP  and  "Actual Data" is ==> response    we must CONVERT this response to Java object
        //    to convert our response to hashmap :
        Map<String, Object> actualData = response.as(HashMap.class);

        // now we can compare them

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.get("completed"), actualData.get("completed"));// first we get from our expected Data then from actual data
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
    }
}
/*
    public void post01b (){
        // set url
        spec.pathParam("first", "todos");

        //2-  set the expected data    HOW TO CREATE PAYLOAD (MAP)
/*
        JsonPlaceHolderBaseUrl obj = new JsonPlaceHolderBaseUrl();
        Map<String,Object> expectedData = obj. expectedData//
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response

        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();                                                 // send Jason inside body

        // Do Assertion
        // to do the Assertion we need "expected Data" and "Actual Data" we are going to comapre these two  DATA
        // here are "expected Data" is MAP  and  "Actual Data" is ==> response    we must CONVERT this response to Java object
        //    to convert our response to hashmap :
        Map<String,Object> actualData = response.as(HashMap.class);

        // now we can compare them

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.get("completed"),actualData.get("completed"));// first we get from our expected Data then from actual data
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
    }

}

 */




