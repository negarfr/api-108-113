package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {

  //we create method to get our Inner Map first, this method will be Public Method which it will rerun Map with two Value Strings
 public Map<String,String> bookingdatesMapSetup(String checkin, String checkout){ //it will accept 2 parameters-whatever we type in parameter is going to be our VALUE

  Map<String,String> bookingdatesMap = new HashMap<>();

  bookingdatesMap.put("checkin", checkin);
  bookingdatesMap.put("checkout", checkout);

 return bookingdatesMap;
    }

 public Map<String,Object> expectedDataSetUp(String firstname,String lastname,Integer totalprice,Boolean depositpaid,Map<String,String >bookingdates,String additionalneeds ) {

     Map<String, Object> expectedData = new HashMap<>();

     expectedData.put("firstname", firstname);
     expectedData.put("lastname", lastname);
     expectedData.put("totalprice", totalprice);
     expectedData.put("depositpaid", depositpaid);
     expectedData.put("bookingdates", bookingdates);
     expectedData.put("additionalneeds", additionalneeds);

     return expectedData;

 }
/*
   Map<String,String> bookingDatesMap = new HashMap<>();
    bookingDatesMap.put("checkin", "2018-01-01");// key and Value
    bookingDatesMap.put( "checkout", "2019-01-01");// key & Value inside the parantes

    Map<String, Object> expectedData = new HashMap<>();
    expectedData.put("firstname","Alex");
    expectedData.put("lastname","Dominguez");
    expectedData.put("totalprice","111");
    expectedData.put( "depositpaid", true);
    expectedData.put( "bookingdates",bookingDatesMap);
    expectedData.put( "additionalneeds", "Breakfast");

 */



    public String expectedDataInString(String firstname, String lastname,Integer totalprice,Boolean depositpaid,String checkin, String checkout, String additionalneeds ) {

        String expectedData= "{\n" +
                "  \"firstname\": \""+firstname+"\",\n" +
                " \"lastname\": \""+lastname+"\",\n" +
                " \"totalprice\": "+totalprice+",\n" +
                " \"depositpaid\": "+depositpaid+",\n" +
                " \"bookingdates\": {\n" +
                " \"checkin\": \""+checkin+"\",\n" +
                " \"checkout\": \""+checkout+"\"\n" +
                "  },\n" +
                " \"additionalneeds\": \""+additionalneeds+"\"\n" +
                "}";
        return expectedData;
    }








}