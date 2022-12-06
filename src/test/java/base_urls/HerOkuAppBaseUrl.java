package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerOkuAppBaseUrl {


    protected RequestSpecification spec;// 1- first we make a RequestSpecification interface and call it spec  we make it protected


    @Before // this annotation is working just before every @Test method

    public void setup() { // 2- second create a method to set up the base url

        // 3- because RequestSpecification spec; is "null" we must assign it and create a spec container
        // to assign it we need SpecBuilder and then use setBaseUri() method and copy and paste our main url (without parameters) in
        // and then .Build() to build it
        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();


    }


         }






