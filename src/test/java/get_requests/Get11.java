package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class Get11 extends GoRestBaseUrl {
/*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status  ==>
        And
            "Tej Bhattacharya, Pres. Harit Chaturvedi, Manisha Marar" are among the users
        And
            The female users are less than or equal to male users
     */
    // to do this test : 1- copy and paste URL into postman to see the data for this URL
    //

    @Test
    public void get11() {

        // set the URL
        spec.pathParam("first", "users");

        // set expected Data

        // send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

// after this point we check the data on console and see in question what they ask us to do

        // Do the Assertion
        response.then().
          assertThat().
          statusCode(200).
          body("meta.pagination.limit", equalTo(10),//value pagination is ib Body so we use body() and pagination is under "meta" in body
                 "meta.pagination.links.current", equalTo("https://gorest.co.in/public/v1/users?page=1"),
                 "data", hasSize(10),// coz under "data" in body we have 10 of each one so we just type data and get its size to count number of Value
                "data.status", hasItem("active"),  // check to see if we have this item
                 "data.name", hasItems("Tej Bhattacharya","Pres. Harit Chaturvedi", "Manisha Marar"));


// TO DO THIS PART OF QUESTION :
// The female users are less than or equal to male users, bellow is what we should do :
// I will compare the number of females and males in 2 ways
// ==> 1st WAY : will get all the genders and count the female users then compare it with males users

        JsonPath jsonPath = response.jsonPath();
        List<String> genderList = jsonPath.getList("data.gender");
        System.out.println("genderList=" + genderList); // get all f & M

        //
        int numberOfFemale = 0;
        for (String w : genderList) { // take all genderList put them in w container one by one
            if (w.equals("female")) {
                numberOfFemale++;
            }
        }
        System.out.println("numberOfFemale=" + numberOfFemale);
        int numberOfMale = genderList.size() - numberOfFemale;

        assertTrue(numberOfFemale <= numberOfMale);

        // 2nd way ; get all females by using Groovy language

        List<String> femalelist = jsonPath.getList("data.findAll{it.gender=='female'}");// we're going to put some condition there so we need getList() and inside it Groovy
        //"data" is in [] so we go to data. inside {} we filter what we need
        System.out.println("femalelist=" + femalelist);

        List<String> malelist = jsonPath.getList("data.findAll{it.gender=='male'}");
        System.out.println("malelist=" + malelist);
    }
}