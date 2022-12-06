package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class Get04 extends JsonPlaceHolderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos  ===> this part asking to "count" the elements
	    And
	        "quis eius est sint explicabo" should be one of the todos title
	    And
	        2, 7, and 9 should be among the userIds
     */

// in above question asking to declare the accept type as well. that is why using AND after WHEN, this means is two actions

    @Test
    public void get04() {
        // Set tge url

        spec.pathParam("first", "todos");

        // set the expected data

        // send request and get responses

        Response response = given().spec(spec).accept(ContentType.JSON).when().get("/{first}");
        response.prettyPrint();

        // DO Assertion
        // hasSize() give us the number of the element Json has
        //check if there is an item in Json body
        response.
                then().
                assertThat().
                statusCode(200).contentType(ContentType.JSON).
                body(" ", hasSize(200),  // hasSize() give us the number of the element Json has
                        "title", hasItem("quis eius est sint explicabo"),    //check if there is an item in Json body
                        "userId", hasItems(2, 7, 9));  // we're checking more than one Item, so we use hasItems()


    }
}

