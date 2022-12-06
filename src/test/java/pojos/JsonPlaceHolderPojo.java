package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // we put this in case we get error "not marked as ignorable"
public class JsonPlaceHolderPojo {

   /*
    1) Create private variables for every key
    2) Create constructors  with all parameters and without any parameter
    3) Create public getters and setters for all variables.
    4) Create toString() method
     */

          /*
         {
 "userId": 55,
"title": "Tidy your room",
  "completed": false
               }
 */

// 1)create private variables for every key

    private Integer userId;
    private String title;
    private Boolean completed;

 // 2)Create Constructors with all parameters

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo() {       // right click -> generate -> select none  we need empty constructor to use in background
    }

   // 3) create public getters and setters for all Variables  -> right click -> generate->  Getter & Setter -> select all

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    // 4) create toString() method = > we create this to just read it on the console


    @Override
    public String toString() {
        return "JasonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }


}
