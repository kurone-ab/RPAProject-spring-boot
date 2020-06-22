package rpa.backend.main.service;

import javax.mail.MessagingException;
import javax.websocket.server.PathParam;
import java.security.NoSuchAlgorithmException;

public interface RegistrationService {
    boolean register(String name, String uid, String upw, String email, String phone) throws NoSuchAlgorithmException, MessagingException;

    boolean authenticate(int id, String authenticationValue);
}
