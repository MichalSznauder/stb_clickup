package pl.akademiaqa.dto.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTaskStatusResponseDto {

    private String status;
    private String type;


    /*
    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "CreateTaskStatusResponseDto{" +
                "status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

     */
}
