package pl.akademiaqa.dto.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTaskCreatorResponseDto {


    @JsonProperty("username")
    private String userName;
    private String email;

/*
    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "CreateTaskCreatorResponseDto{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

 */
}
