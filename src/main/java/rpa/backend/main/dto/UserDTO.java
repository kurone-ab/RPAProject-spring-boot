package rpa.backend.main.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
//front로 User데이터를 보내기 위한 DTO
public class UserDTO {
    private final int id;
    private final String name;
    private final String auth;
    private final String error;

    @Builder
    public UserDTO(int id, String name, String auth, String error) {
        this.id = id;
        this.name = name;
        this.auth = auth;
        this.error = error;
    }
}
