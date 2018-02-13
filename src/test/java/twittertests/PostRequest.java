package twittertests;

import base.TwitterSetup;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class PostRequest extends TwitterSetup {

    private String tweetID;

    @Test(groups="mytweets")
    public void postTweet() {

        Response response =
                given().
                        log().ifValidationFails().

                        param("status", "My Automated Rest Assured Test Tweets!")
                        .when()
                        .post("/update.json");


        tweetID= response.path("id_str");
        System.out.println(tweetID);


    }



    @Test(dependsOnMethods = "postTweet")
    public void readTweet(){

        given().queryParam("id", tweetID)
                .when()
                .get("/show.json")
                .prettyPrint();

    }
}
