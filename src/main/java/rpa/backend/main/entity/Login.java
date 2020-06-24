package rpa.backend.main.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//Login Table
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn
    private User user;
    private String password;

    @Builder
    public Login(User user, String password) {
        this.user = user;
        this.password = password;
    }
}
