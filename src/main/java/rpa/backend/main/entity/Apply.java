package rpa.backend.main.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
//Apply Table
public class Apply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "text")
    private String introduce;
    @Column(columnDefinition = "text")
    private String study;
    @Column(columnDefinition = "text")
    private String experience;
    private String github;
    @OneToOne
    @JoinColumn
    private User user;

    @Builder
    public Apply(String introduce, String study, String experience, String github, User user) {
        this.introduce = introduce;
        this.study = study;
        this.experience = experience;
        this.github = github;
        this.user = user;
    }
}
