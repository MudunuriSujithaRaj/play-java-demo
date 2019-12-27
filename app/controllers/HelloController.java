package controllers;
import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.Controller;
import play.mvc.Result;


import java.net.PasswordAuthentication;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;



public class HelloController extends Controller{
    Map<Integer,String> map = new HashMap<>();
    public Result giveResult(){

      return ok("Hello Everyone!!!");
    }
    public Result HelloUser(String name){
        String message="Hello "+name+" !!";
        return ok(message);
    }
    public Result helloUserWithDetails(){
       JsonNode requestJson = request().body().asJson();
        String firstName = null;
        String lastName = null;

        if(requestJson.has("first_name"))
        {
            firstName = requestJson.get("first_name").asText();
        }
        if(requestJson.has("last_name"))
        {
            lastName = requestJson.get("last_name").asText();
        }
        if(firstName != null && lastName != null ) {
            String message = "Hello " + firstName + lastName + " !!";
            return ok(message);
        }
        return badRequest("Provide correct credentials!!");
    }

    public Result UserWithDetailsValid(){

        JsonNode requestJson = request().body().asJson();
        String Username = null;

        int UserID = 0;
        String msg = null;

        if(requestJson.has("UserID"))
        {
            UserID = requestJson.get("UserID").asInt();
        }
        if(requestJson.has("Username"))
        {
            Username = requestJson.get("Username").asText();
        }

        if(Username != null  && UserID != 0) {
            String message = "Successfully Entered details";
            map.put(UserID,Username);
            for(Integer id : map.keySet()) {
                String key = id.toString();
                String value = map.get(id).toString();
                msg = " id : " + key +"\n name : " + value;


                    return ok(msg);

            }
        }
        return badRequest("Provide correct credentials!!");
    }

}
