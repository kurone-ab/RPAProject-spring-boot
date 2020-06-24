package rpa.backend.main.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rpa.backend.main.dto.RegistrationDTO;
import rpa.backend.main.exception.UniqueConstraintViolationException;
import rpa.backend.main.service.RegistrationService;

import javax.mail.MessagingException;
import javax.websocket.server.PathParam;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/new")
    @ResponseBody
    //"/register/new"으로 접속해 유저의 가입 절차를 진행
    public RegistrationDTO registerNewClient(@PathParam("name") String name, @PathParam("upw") String upw, @PathParam("email") String email, @PathParam("phone") String phone) {
        try {
            return RegistrationDTO.builder().result(this.registrationService.register(name, upw, email, phone)).build();
        } catch (NoSuchAlgorithmException | MessagingException e) {
            e.printStackTrace();
            return RegistrationDTO.builder().error("인증 이메일 발송에 실패했습니다!").build();
        } catch (UniqueConstraintViolationException exception) {
            return RegistrationDTO.builder().error("중복된 이메일 입니다!").build();
        }
    }

    @PostMapping("/auth")
    //"/register/auth"으로 접속해 유저의 이메일 인증 절차를 진행
    public boolean emailAuthenticate(@PathParam("id") int id, @PathParam("value") String value) {
        return this.registrationService.authenticate(id, value);
    }

}
