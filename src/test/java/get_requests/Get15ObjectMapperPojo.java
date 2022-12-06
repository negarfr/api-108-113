package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import test_data.JsonPlaceHolderTestData;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get15ObjectMapperPojo extends JsonPlaceHolderBaseUrl {
    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */
@Test
    public void get15(){
    // Set the URL
    spec.pathParams("first","todos","second",198);

// set the expected Data == > now we have to create PojoClass
// but first need convert this string in body to pojo

String expectedDataInString= new JsonPlaceHolderTestData().expectedDataInString(10,"quis eius est sint explicabo",true);
// create new object for JsonPlaceHolderTestdata

JsonPlaceHolderPojo expectedData =  JsonUtils.convertJsonToJavaObject(expectedDataInString, JsonPlaceHolderPojo.class);

System.out.println("expectedData =" + expectedData );

// send request
Response response = given().spec(spec).when().get("/{first}/{second}");

// Do assertion == > need to convert to pojo class with ObjectMapper
// need response to be written like expectedData
JsonPlaceHolderPojo actualData = JsonUtils.convertJsonToJavaObject(response.asString(), JsonPlaceHolderPojo.class);
                              //use JsonUtils class=> our Response is in Json format we get is asString and then convert to JsonPlaceHolderPojo class
System.out.println("actualData = " + actualData);

    assertEquals(200,response.statusCode());
    assertEquals(expectedData.getUserId(),actualData.getUserId());
    assertEquals(expectedData.getTitle(),actualData.getTitle());
    assertEquals(expectedData.getCompleted(),actualData.getCompleted());

}


}
