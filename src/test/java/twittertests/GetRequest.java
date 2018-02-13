package twittertests;

import base.TwitterSetup;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

public class GetRequest extends TwitterSetup {


    @Test(enabled = false)
    public void getMyTweets() {

        Response response = given().
                when().
                get("/user_timeline.json");

        List<Header> header = response.getHeaders().asList();


        for (Header str : header) {
            System.out.println(str.getName() + " : " + str.getValue());
        }


     //   System.out.println(response.then().body("id_str[0]", equalTo("962899345195413505")).extract().path("text[0]"));
        String responseString= response.asString();
        List<String> tweets = from(responseString).get("text");

        // System.out.println(response.getBody().asString());

        for (String str : tweets) {
            System.out.println(str);
        }


    }





}
