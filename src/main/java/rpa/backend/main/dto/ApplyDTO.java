package rpa.backend.main.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class ApplyDTO {
    private final int id;
    private final int userId;
    private final String userName;
    private final String introduce;
    private final String study;
    private final String experience;
    private final String github;

    @Builder
    public ApplyDTO(int id, int userId, String userName, String introduce, String study, String experience, String github) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.introduce = introduce;
        this.study = study;
        this.experience = experience;
        this.github = github;
    }
}
