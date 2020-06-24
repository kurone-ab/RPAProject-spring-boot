package rpa.backend.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.*;
import java.util.Date;


@Service
public class MailServiceImpl implements MailService {
    private final JavaMailSender javaMailSender;

    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    //인증 메일 발송하기
    public void sendMail(String email, String link) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        message.setSubject("(주)퐁신 이메일 인증");
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setText("안녕하세요.\n아래 링크를 통해 이메일 인증을 완료해주시길 바랍니다.\n\n[링크]\n"+link+"\n\n 감사합니다.");
        message.setSentDate(new Date());
        javaMailSender.send(message);
    }

}