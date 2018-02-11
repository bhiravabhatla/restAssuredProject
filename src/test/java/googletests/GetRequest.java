package googletests;

import base.GoogleSetup;
import io.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest extends GoogleSetup {


    @Test
    @Parameters("key")
    public void getDistance(String key){

        Response response=given()
                .param("units","metric")
                .param("origins","Washington,DC")
                .param("destinations","New+York+City,NY")
                .param("key",key)
                .when()
                .get("/distancematrix/json");

        System.out.println(response.getBody().prettyPrint());


    }

    @Test
    @Parameters("key")
    public void validateAttribute(String key){
        given()
                .param("units","metric")
                .param("origins","Washington,DC")
                .param("destinations","New+York+City,NY")
                .param("key",key)
                .when()
                .get("/distancematrix/json")
                .then()
                .body("rows[0].elements[0].distance.text", equalTo("362 km"));


    }
}
