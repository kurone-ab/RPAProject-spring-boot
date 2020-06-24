package rpa.backend.main.entity;

import lombok.*;
import org.springframework.security.core.Authentication;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"id", "email"}))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 40)
    private String email;
    private String name;
    private String phoneNum;
    private String authenticationValue;
    private boolean authenticated;
    @Enumerated(EnumType.STRING)
    private Auth auth;

    @Builder
    public User(String email, String name, String phoneNum, boolean authenticated, String authenticationValue, Auth auth) {
        this.email = email;
        this.name = name;
        this.phoneNum = phoneNum;
        this.authenticated = authenticated;
        this.authenticationValue = authenticationValue;
        this.auth = auth;
    }
}
