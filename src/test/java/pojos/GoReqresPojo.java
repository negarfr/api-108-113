package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoReqresPojo {

        //                "name": "morpheus",
        //                "job": "leader"
        //                }
        //Private Variable

    private String name;
    private String job;

    public GoReqresPojo(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public GoReqresPojo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "GoReqresPojo{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
