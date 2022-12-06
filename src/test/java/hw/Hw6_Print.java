package hw;

import base_urls.RegresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Hw6_Print extends RegresBaseUrl {
 /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */

@Test
    public void hw6(){

    spec.pathParam("first","unknown");

   Response response=  given().spec(spec).when().get("/{first}");
   response.prettyPrint();

   // 1)Status code is 200
    response.then().assertThat().statusCode(200);

    //  2)Print all pantone_values  ==> we use JsonPath to Navigate and manipulate Data in Json format

    JsonPath json = response.jsonPath(); // convert response to JsonPath
    List<String> pantone_values = json.getList("data.pantone_values"); // put them in List as Data are in List
    System.out.println("pantone_values="+pantone_values);

    // 3)Print all ids greater than 3 on the console
    // Assert that there are 3 ids greater than 3

     List<Integer> idsGreaterThan3 = json.getList("data.findAll{it.id>3}.id");
    System.out.println("idsGreaterThan3=" + idsGreaterThan3);
    assertEquals(3,idsGreaterThan3.size());

  //  4)Print all names whose ids are less than 3 on the console
   // Assert that the number of names whose ids are less than 3 is 2

    List<String> namesIdLessThan3 = json.getList("data.findAll{it.id<3}.name");
    System.out.println(" namesIdLessThan3= " +  namesIdLessThan3);
    assertEquals(2,namesIdLessThan3.size());

}









}
