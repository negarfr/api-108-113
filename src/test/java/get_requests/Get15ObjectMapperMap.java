package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get15ObjectMapperMap extends JsonPlaceHolderBaseUrl {
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
    // we going to do this with map and ObjectMapper coz is more using in market

    @Test
    public void get15(){
        //set url
        spec.pathParams("first","todos","second",198);
   // set the expected data ==> we are going to use ObjectMapper which convert this body to Java object by help of ObjectMapper

   /* String expectedDataInString = "{\n" +  ==>first need to do convert our expectData to String then we use it in bottom
        "   \"userId\": 10,\n" +
        "   \"id\": 198,\n" +
        "   \"title\": \"quis eius est sint explicabo\",\n" +
        "  \"completed\": true\n" +
        " }" ;                       ==> but we do not want anything like this in our coding page so we do concatination
        GO CHECK " JsonPlaceHoldertestdata we create method there and then Object in below to be able to use it
            */

String expectedDataInString = new JsonPlaceHolderTestData().expectedDataInString(10,"quis eius est sint explicabo",true);

Map<String,Object> expecteddata = JsonUtils.convertJsonToJavaObject(expectedDataInString, HashMap.class);
System.out.println("expecteddata=" + expecteddata);

Response response = given().spec(spec).when().get("/{first}/{second}");
response.prettyPrint();

    // do assertion  ==> use objectMapper
Map<String,Object> actualData =  JsonUtils.convertJsonToJavaObject(response.asString(), HashMap.class);
System.out.println("actualData=" +  actualData);                // convert our response to map

assertEquals(200,response.statusCode());
assertEquals(expecteddata.get("userId"),actualData.get("userId"));
assertEquals(expecteddata.get("title"),actualData.get("title"));
assertEquals(expecteddata.get("completed"),actualData.get("completed"));


    }

}
