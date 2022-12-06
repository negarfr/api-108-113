package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoRestPojo {    /* 1) Create private variables for every key
                             2) Create constructors with all parameters and without any parameter
                             3) Create public getters and setters for all variables.
                            4) Create toString() method. look down example is from Get13Pojo
                                    Response body should be like
                                                          {
                                                         "meta": null,
                                                         "data": {
                                                         "id": 131,
                                                         "name": "Prem Pilla",
                                                         "email": "pilla_prem@mueller.info",
                                                         "gender": "female",
                                                         "status": "active"
                                                                     }       */
    private Object meta;  // private variable for every key
    private GoRestDataPojo data;
    public GoRestPojo(Object meta, GoRestDataPojo data) {     //constructers
        this.meta = meta;
        this.data = data;
    }
    public GoRestPojo() {  // empty constructer
    }
    public Object getMeta() {return meta;}

    public void setMeta(Object meta) {this.meta = meta;}

    public GoRestDataPojo getData() {return data;}

    public void setData(GoRestDataPojo data) {this.data = data;}

    @Override
    public String toString() {
        return "GoRestPojo{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}










/*

 */