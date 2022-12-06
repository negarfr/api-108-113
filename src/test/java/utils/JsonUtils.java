package utils;

import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtils {

    protected static ObjectMapper mapper ;
        static {  //static block works before every process and this object will be created once and used every classes.
            mapper = new ObjectMapper();
        }
    //This method will accept two parameters and convert first parameter to second parameter data type by using ObjectMapper class.
    public static <T> T convertJsonToJavaObject(String json, Class<T> cls) { // Generic Method
        // <T> means any Data type      and Class <t> means any class and we name is cls
        T javaResult = null; // we have to initialize this
        try {                       // if we dont do try and catch the method is going to complain
          javaResult =  mapper.readValue(json, cls);
        }catch (IOException e) {
            e.printStackTrace();
        }

        return javaResult;
    }


}
