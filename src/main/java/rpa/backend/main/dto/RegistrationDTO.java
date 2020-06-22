package rpa.backend.main.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class RegistrationDTO {
    private final boolean result;
    private final String error;

    @Builder
    public RegistrationDTO(boolean result, String error) {
        this.result = result;
        this.error = error;
    }
}
