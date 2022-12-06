package post_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Post03Pojo extends JsonPlaceHolderBaseUrl {
/*
         Given
            1) https://jsonplaceholder.typicode.com/todos
            2)  {                                           // to post : we need the URL and BODY
                "userId": 55,
                "title": "Tidy your room",
                "completed": false
                }
        When
            I send POST Request to the Url
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
//==============================================================================================

    @Test
    public void post03(){
        // set the url

    spec.pathParam("first","todos");

    // set the expected data == > we are going to create Pojo class

        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(55,"Tidy your room", false);
        System.out.println("expectedData=" + expectedData);

    // send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

     // do Assertion ==> to do this we need actual and expected
        JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class);// is going to convert our response to this class=> De-Serialization
        System.out.println("actualData="+actualData);// if we run this we will get error for "id" we need to sort it with
              // JsonIgnoreProperties//

       assertEquals(201,response.statusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());



    }



}
