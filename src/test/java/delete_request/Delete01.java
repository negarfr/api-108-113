package delete_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Delete01 extends JsonPlaceHolderBaseUrl {
/*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

   /*
How to Automate Delete Request in API testing

1) Create new Data by using "Post Request"
2) Use "Delete request" to Delete the data

Note : Never ever Delete, Create data to delete

 */
    @Test
    public void delete01(){

    // Set the url
    spec.pathParams("first","todos","second",198);

    // set the expected data
    // we expect an empty Map accoring to our test
    Map<String,Object> expectedData = new HashMap<>();
    System.out.println("expectedData=" + expectedData);

    // Send the request and get the response

    Response response = given().spec(spec).when().delete("/{first}/{second}");
    response.prettyPrint();

    // Do Assertion
   Map<String, Object> actualData = response.as(HashMap.class); //first convert response into the map java Object
         System.out.println("actualData=" +actualData);

    assertEquals(200,response.statusCode());
    assertEquals(expectedData,actualData);

    // or
    assertEquals(expectedData.size(),actualData.size());

    //or
    assertTrue(actualData.isEmpty());

    //or
    response.then().assertThat().body("isEmpty()", Matchers.is(true));

}


}
