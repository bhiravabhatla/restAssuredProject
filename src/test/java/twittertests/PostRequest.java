package twittertests;

import base.TwitterSetup;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequest extends TwitterSetup {

    @Test
    public void postTweet() {

        Response response =
                given().
                        param("status", "My Automated Rest Assured Test Tweet!")
                        .when()
                        .post("/update.json");

        System.out.println(response.asString());


    }
}
