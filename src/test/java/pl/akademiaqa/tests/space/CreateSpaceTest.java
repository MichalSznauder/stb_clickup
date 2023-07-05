package pl.akademiaqa.tests.space;

import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.requests.space.CreateSpaceRequest;
import pl.akademiaqa.requests.space.DeleteSpaceRequest;
import pl.akademiaqa.requests.space.UpdateSpaceRequest;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateSpaceTest {

    private static final String SPACE_NAME = "MY PERFECT SPACE";

//  /team/26484503/space

    @Test
    void createSpaceTest() {

        JSONObject space = new JSONObject();
        space.put("name", SPACE_NAME);

        final var response = CreateSpaceRequest.createSpace(space);

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("name")).isEqualTo(SPACE_NAME);

        final var spaceId = response.jsonPath().getString("id");

        JSONObject updatedSpace = new JSONObject();
        updatedSpace.put("name", "Updated Space Name");
        updatedSpace.put("features.sprints.enabled", true);


        final var updateResponse = UpdateSpaceRequest.updateSpace(updatedSpace, spaceId);
        assertThat(updateResponse.jsonPath().getString("name")).isEqualTo("Updated Space Name");
        assertThat(updateResponse.statusCode()).isEqualTo(200);
       // Assertions.assertThat(updateResponse.jsonPath().getString("features.sprints.enabled")).isEqualTo("true");

        final var deleteResponse = DeleteSpaceRequest.deleteSpace(spaceId);
        assertThat(deleteResponse.statusCode()).isEqualTo(200);
    }
}
