package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import static io.restassured.RestAssured.oauth;

public class TwitterSetup {

   @BeforeSuite
   @Parameters({"consumerKey","consumerSecret","AccessToken","AccessSecret"})
   public void setup(String consumerKey, String consumerSecret, String AccessToken, String AccessSecret){

        RestAssured.baseURI="https://api.twitter.com/1.1";
        RestAssured.basePath="/statuses";
        RestAssured.authentication= oauth(consumerKey,  consumerSecret,  AccessToken,  AccessSecret);
    }


}
