package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class get07 extends JsonPlaceHolderBaseUrl {
    /*
        Given
	   	    https://jsonplaceholder.typicode.com/todos
		When
			 I send GET Request to the URL
		Then
			 1)Status code is 200
			 2)Print all ids greater than 190 on the console
			   Assert that there are 10 ids greater than 190
			 3)Print all userIds whose ids are less than 5 on the console
			   Assert that the number of userIds whose ids are less than 5 is 4
			 4)Print all titles whose ids are less than 5
			   Assert that "delectus aut autem" is one of the titles whose id is less than 5
*/
@Test
    public void get07() {
    // set the url
    spec.pathParam("first", "todos");
    // set the expected


    // send the request
    Response response = given().spec(spec).when().get("/{first}");
    response.prettyPrint();

    // Do Assertion
    // status code 200
    assertEquals(200, response.statusCode());

    //2)Print all ids greater than 190 on the console
    // Assert that there are 10 ids greater than 190

    // 1st WAY
    JsonPath jsonPath = response.jsonPath();// need to convert response to jsonpath so can get the data from outside the body

    List<Integer> ids = jsonPath.getList("id"); //getlist() will give me all ids in list and give me

    List<Integer> idsGreaterThan190 = new ArrayList<>(); // everything after filtering by loop comes to this list

    System.out.println("ids = " + ids);

    for (int w : ids) { // to have all ids one by one

        if (w > 190) { // then we if statement we filter them
            idsGreaterThan190.add(w);
        }
    }
    System.out.println("idsGreaterThan190=" + idsGreaterThan190);
    assertEquals(10, idsGreaterThan190.size()); // DO ASSERTION NOW

    // 2nd WAY- if you need to take a data from listed element you can use "Groovy Language"
    List<Integer> idsGreaterThan190Groovy = jsonPath.getList("findAll{it.id>190}.userId"); // Groovy language (" it " is like 't->' in lambda )
    // going to filter all Json data their id is bigger than 190 with "findAll"

    System.out.println("idsGreaterThan190Groovy =" + idsGreaterThan190Groovy);

    assertEquals(10, idsGreaterThan190Groovy.size());

    //3)Print all userIds whose ids are less than 5 on the console
    // Assert that the number of userIds whose ids are less than 5 is 4

    List<Integer> userIds = jsonPath.getList("findAll{it. id<5}.userId");

    System.out.println(" userIds= " + userIds);

    assertEquals(4, userIds.size());


    // 4)Print all titles whose ids are less than 5
    // Assert that "delectus aut autem" is one of the titles whose id is less than 5

    List<String> titles = jsonPath.getList("findAll{it.id<5}.title");
    System.out.println("titles =" + titles);
    // 1st way
    assertTrue("'delectus aut autem does not exist", titles.contains("delectus aut autem"));
    // whenever we have to use contains () we must use assertTrue or assert false()
}

}