package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13Pojo extends GoRestBaseUrl {
/*
        Given
            https://gorest.co.in/public/v1/users/131
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
                       {
                     "meta": null,
                      "data": {
                        "id": 131,
                       "name": "Prem Pilla",
                         "email": "pilla_prem@mueller.info",
                        "gender": "female",
                             "status": "active"
    }
}
    */
    // will do our assertion with pojo that is why is pojo
@Test
    public void get13(){
    // set URL
    spec.pathParams("first", "users","second",131);

    // Set expected data ==> we need to create Pojo and we need two classes based on text
// create object from GoRestDataPojo
    GoRestDataPojo goRestDataPojo = new GoRestDataPojo("Prem Pilla", "pilla_prem@mueller.info", "female", "active" );
    GoRestPojo expectedData = new GoRestPojo(null, goRestDataPojo);
    System.out.println("expectedData=" +expectedData);


    // send the request and get the response
  Response response = given().spec(spec).when().get("/{first}/{second}");
  response.prettyPrint();

    // Do Assertion
    GoRestPojo actualData = response.as(GoRestPojo.class);
    System.out.println(" actualData=" +  actualData);

    assertEquals(200,response.statusCode());
    assertEquals(expectedData.getMeta(),actualData.getMeta());// from ecpected data am going to get meta and from actual and they both will be null
    assertEquals(goRestDataPojo.getGender(),actualData.getData().getName());
    assertEquals(goRestDataPojo.getEmail(),actualData.getData().getEmail());
    assertEquals(goRestDataPojo.getGender(),actualData.getData().getGender());
    assertEquals(goRestDataPojo.getStatus(),actualData.getData().getStatus());

}
















}

















