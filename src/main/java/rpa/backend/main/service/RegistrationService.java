package rpa.backend.main.service;

import org.hibernate.exception.ConstraintViolationException;
import rpa.backend.main.exception.UniqueConstraintViolationException;

import javax.mail.MessagingException;
import javax.websocket.server.PathParam;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLIntegrityConstraintViolationException;

public interface RegistrationService {
    boolean register(String name, String uid, String upw, String email, String phone) throws NoSuchAlgorithmException, MessagingException, UniqueConstraintViolationException;

    boolean authenticate(int id, String authenticationValue);
}
