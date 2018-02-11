package base;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest {


    @Test
    public void getDistance(){

        Response response=given()
                .param("units","metric")
                .param("origins","Washington,DC")
                .param("destinations","New+York+City,NY")
                .param("key","AIzaSyCYg1aYNO2luteOywcpgMy-f0Qb6hsD5b0")
                .when()
                .get("/distancematrix/json");

        System.out.println(response.getBody().prettyPrint());


    }

    @Test
    public void validateAttribute(){
        given()
                .param("units","metric")
                .param("origins","Washington,DC")
                .param("destinations","New+York+City,NY")
                .param("key","AIzaSyCYg1aYNO2luteOywcpgMy-f0Qb6hsD5b0")
                .when()
                .get("/distancematrix/json")
                .then()
                .body("rows[0].elements[0].distance.text", equalTo("362 km"));


    }
}
