package rpa.backend.main.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
//front로 가입 결과 데이터를 보내기 위한 DTO
public class RegistrationDTO {
    private final boolean result;
    private final String error;

    @Builder
    public RegistrationDTO(boolean result, String error) {
        this.result = result;
        this.error = error;
    }
}
