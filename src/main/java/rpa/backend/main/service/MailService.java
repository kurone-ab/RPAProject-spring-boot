package rpa.backend.main.service;

import javax.mail.MessagingException;

public interface MailService {
    void sendMail(String email, String link) throws MessagingException;
}
