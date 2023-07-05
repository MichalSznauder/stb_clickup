package pl.akademiaqa.tests.e2e;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.akademiaqa.dto.request.CreateTaskRequestDto;
import pl.akademiaqa.dto.request.UpdateTaskRequestDto;
import pl.akademiaqa.requests.list.CreateListRequest;
import pl.akademiaqa.requests.space.CreateSpaceRequest;
import pl.akademiaqa.requests.space.DeleteSpaceRequest;
import pl.akademiaqa.requests.tasks.CreateTaskRequest;
import pl.akademiaqa.requests.tasks.UpdateTaskRequest;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateTaskE2ETest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateTaskE2ETest.class);
    private static String spaceName = "SPACE E2E";
    private static String listName = "ZADANIA";
    private static String taskName = "jeeer";
    private String spaceId;
    private String listId;
    private String taskId;

    @Test
    void UpdateTaskE2ETest(){
        spaceId = createSpaceStep();
        LOGGER.info("Space created with id: {}", spaceId);

        listId = createListStep();
        LOGGER.info("List created with id: {}", listId);

        taskId = createTaskStep();
        LOGGER.info("Task created with id: {}", taskId);

        updateTaskStep();

        closeTaskStep();

        deleteSpaceStep();
    }

    private String createSpaceStep(){

        JSONObject json = new JSONObject();
        json.put("name", spaceName);


    final var response = CreateSpaceRequest.createSpace(json);
    assertThat(response.statusCode()).isEqualTo(200);

    JsonPath jsonData = response.jsonPath();
    assertThat(jsonData.getString("name")).isEqualTo(spaceName);

    return jsonData.getString("id");
}

    private String createListStep(){
        JSONObject json = new JSONObject();
        json.put("name", listName);

        final var response = CreateListRequest.createList(json, spaceId);
        assertThat(response.statusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        assertThat(jsonData.getString("name")).isEqualTo(listName);

        return jsonData.getString("id");
    }

    private String createTaskStep(){

//        JSONObject task = new JSONObject();
//        task.put("name", taskName);
//        task.put("description", "Ciekawe jak to działa");
//        task.put("status", "to do");
//        task.put("priority", JSONObject.NULL);
//        task.put("parent", JSONObject.NULL);
//        task.put("time_estimate", JSONObject.NULL);
//        task.put("assignees", JSONObject.NULL);
//        task.put("archived", false);


        CreateTaskRequestDto taskDto = new CreateTaskRequestDto();
        taskDto.setName(taskName);
        taskDto.setDescription("Ciekawe jak to działa");
        taskDto.setStatus("to do");




        // serializacja

        final var response = CreateTaskRequest.createTask(taskDto, listId);

        LOGGER.info("CREATE TASK RESPONSE OBJ: {}", response);



//        assertThat(response.statusCode()).isEqualTo(200);
//
//        JsonPath jsonData = response.jsonPath();
//        assertThat(jsonData.getString("name")).isEqualTo(taskName);
//        assertThat(jsonData.getString("description")).isEqualTo("Ciekawe jak to działa");
//
//        return jsonData.getString("id");

        assertThat(response.getName()).isEqualTo(taskName);
        assertThat(response.getDescription()).isEqualTo("Ciekawe jak to działa");




        return response.getId();
    }

    private void updateTaskStep(){

        JSONObject updateTask = new JSONObject();
        updateTask.put("name", "Zmieniona nazwa taska" );
        updateTask.put("description", "Zmieniony opis taska");



        // usuwamy to POJO , nie chcemy tego POJO
//        UpdateTaskRequestDto taskDto = new UpdateTaskRequestDto();
//        taskDto.setName("Zmieniona nazwa taska");
//        taskDto.setDescription("Zmieniony opis taska");


        final var response = UpdateTaskRequest.updateTask(updateTask, taskId);
        assertThat(response.statusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        assertThat(jsonData.getString("name")).isEqualTo("Zmieniona nazwa taska");
        assertThat(jsonData.getString("description")).isEqualTo("Zmieniony opis taska");

    }


    private void closeTaskStep(){
        JSONObject closeTask = new JSONObject();
        closeTask.put("status","complete");

        final var response = UpdateTaskRequest.updateTask(closeTask, taskId);
        assertThat(response.statusCode()).isEqualTo(200);


        JsonPath jsonData = response.jsonPath();
        assertThat(jsonData.getString("status.status")).isEqualTo("complete");

    }

            private void deleteSpaceStep(){
                final var response = DeleteSpaceRequest.deleteSpace(spaceId);
                assertThat(response.statusCode()).isEqualTo(200);


            }

}
