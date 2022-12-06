package post_request;

import base_urls.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.CountryPost;
import pojos.States;
import utils.JsonUtils;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utils.AuthenticationGMIBank.generateToken;
public class Post06 extends GMIBankBaseUrl {
    /*
         Given
            https://www.gmibank.com/api/tp-countries
            {
              "name": "USA",
              "states": [
                {
                  "id": 12,
                  "name": "California",
                  "tpcountry": null
                }
              ]
            }
        When
 		    I send POST Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
                                    "id": 171555,
                                    "name": "USA",
                                    "states": [
                                        {
                                            "id": 12,
                                            "name": "California",
                                            "tpcountry": null
                                        }
                                    ]
                                  }
   */

    @Test
    public void post06(){

        spec.pathParam("first","tp-countries");

        // expected Data   ==> create new pojo class with the body first in https://json2csharp.com/code-converters/json-to-pojo then create class here and
        // call is "ststes" for inner and CountryPost class for outer
        States states = new States(12, "California",null);

        ArrayList<States> statesArrayList = new ArrayList<>();
        statesArrayList.add(states);// if you keep the mouse on after comma after "USA" in  CountryPost expectedData
        // it says create a ArrayList
        CountryPost expectedData = new CountryPost("USA",statesArrayList );

        //Send the request and get the response
        Response response = given().
                spec(spec).
                contentType(ContentType.JSON).
                headers("Authorization","Bearer "+generateToken()).
                body(expectedData).when().
                post("/{first}");

        response.prettyPrint();

        // Do Assertion
        CountryPost actualData = JsonUtils.convertJsonToJavaObject(response.asString(),CountryPost.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(states.getId(),actualData.getStates().get(0).getId());
        assertEquals(states.getName(),actualData.getStates().get(0).getName());

    }





















}
