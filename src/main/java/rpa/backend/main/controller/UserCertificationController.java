package rpa.backend.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rpa.backend.main.dto.UserDTO;
import rpa.backend.main.service.UserService;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/user")
public class UserCertificationController {
    private final UserService userService;

    @Autowired()
    public UserCertificationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public UserDTO userCertification(@RequestParam("id")String email, @RequestParam("pw") String pw) {
        try {
            return this.userService.userCertificate(email, pw);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return UserDTO.builder().build();
        }
    }
}
