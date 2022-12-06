package hw;

import base_urls.RegresBaseUrl;
import org.junit.Test;
import test_data.ReqresTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Hw7_Post extends RegresBaseUrl {
  /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

@Test
    public void hw7() {
    spec.pathParam("first", "users");

    // set the expectedData
    //create ReqresTestData class and create methods there for Map to get expectedData

    ReqresTestData reqresTestData = new ReqresTestData();
    Map<String,String > expectedData = reqresTestData.reqresUsersSetUp("morpheus","leader");
    // create reqresTestData and reqresUsersSetUp in Test_Data
    System.out.println("expectedData = " + expectedData);

    


}

}







