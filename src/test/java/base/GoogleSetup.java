package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class GoogleSetup {

    @BeforeSuite
    @Parameters({"baseUrl","basePath"})
    public void setup(String baseUrl, String basePath){
        RestAssured.baseURI=baseUrl;
        RestAssured.basePath=basePath;


    }

}
