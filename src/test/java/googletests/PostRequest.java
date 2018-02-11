package googletests;

import base.GoogleSetup;
import io.restassured.http.ContentType;
import models.PlaceAddModel;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostRequest extends GoogleSetup {


    @Test
    @Parameters("key")
    public void addAPlace(String key){
        List<String> list= new ArrayList<String>();

        PlaceAddModel placeAddModel = new PlaceAddModel();
        placeAddModel.setLocation( new HashMap<String, Double>(){{
            put("lat",-33.8669710);
            put("lng", 151.1958750);
        }});

        placeAddModel.setAccuracy(60);
        placeAddModel.setName("Santosh MithaiWala");
        placeAddModel.setAddress("hello");
        placeAddModel.setPhone("(02) 9374 4000");
        list.add("shoe_store");
        placeAddModel.setTypes(list);
        placeAddModel.setWebsite("");
        placeAddModel.setLanguage("");

        given()
                .queryParam("key",key)
                .contentType(ContentType.JSON)
                .body(placeAddModel)
                .when()
                .post("/place/add/json")
                .getBody().prettyPrint();



    }

}
