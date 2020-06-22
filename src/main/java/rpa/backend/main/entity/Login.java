package rpa.backend.main.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Login {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn
    private User user;
    @Column(unique = true, length = 40)
    private String uid;
    private String password;

    @Builder
    public Login(User user, String uid, String password) {
        this.user = user;
        this.uid = uid;
        this.password = password;
    }
}
