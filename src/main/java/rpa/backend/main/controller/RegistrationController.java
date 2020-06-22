package rpa.backend.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rpa.backend.main.service.RegistrationService;

import javax.mail.MessagingException;
import javax.websocket.server.PathParam;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/new")
    public boolean registerNewClient(@PathParam("name") String name, @PathParam("uid") String uid, @PathParam("upw") String upw, @PathParam("email") String email, @PathParam("phone") String phone) {
        try {
            return this.registrationService.register(name, uid, upw, email, phone);
        } catch (NoSuchAlgorithmException | MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }

    @PostMapping("/auth")
    public boolean emailAuthenticate(@PathParam("id") int id, @PathParam("value") String value) {
        return this.registrationService.authenticate(id, value);
    }

}
