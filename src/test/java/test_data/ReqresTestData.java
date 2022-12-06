package test_data;

import jdk.internal.access.JavaSecurityAccess;

import java.util.HashMap;
import java.util.Map;

public class ReqresTestData {
    /*
                    }
                "name": "morpheus",
                "job": "leader"
                }
     */

    public Map<String, String> regresTestData(String name, String job) {
        Map<String, String> reqresTesData = new HashMap<>();
        reqresTesData.put("name", name);
        reqresTesData.put("job", job);

        return reqresTesData;
    }
    public Map<String, String> reqresUsersSetUp(String morpheus, String leader) {
            Map<String,String> reqresUsersSetUp = new HashMap<>();
        reqresUsersSetUp.put("name",morpheus );
        reqresUsersSetUp.put("job",leader);

        return reqresUsersSetUp;
    }


}