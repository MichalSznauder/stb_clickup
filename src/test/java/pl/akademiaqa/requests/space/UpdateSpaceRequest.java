package pl.akademiaqa.requests.space;

import io.restassured.response.Response;
import org.json.JSONObject;
import pl.akademiaqa.properties.ClickUpProperties;
import pl.akademiaqa.requests.BaseRequest;
import pl.akademiaqa.url.ClickUpUrl;

import static io.restassured.RestAssured.given;

public class UpdateSpaceRequest {

    public static Response updateSpace(JSONObject updateSpace, String spaceId) {

        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(updateSpace.toString())
                .when()
                .put(ClickUpUrl.getSpaceUrl(spaceId))
                .then()
                .log().ifError()
                .extract()
                .response();

    }




}
