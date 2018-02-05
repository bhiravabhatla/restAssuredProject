package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetRequest {

    @BeforeMethod
    @Parameters({"baseUrl","basePath"})
    public void setup(String baseUrl, String basePath){
        RestAssured.baseURI=baseUrl;
        RestAssured.basePath=basePath;

    }

    @Test
    public void getDistance(){

        given()
                .param("units","imperial")
                .param("origins","Washington,DC")
                .param("destinations","New+York+City,NY")
                .param("key","AIzaSyCYg1aYNO2luteOywcpgMy-f0Qb6hsD5b0")
         .when()
                .get("/distancematrix/json")
         .then()
                .statusCode(200);
    }
}
