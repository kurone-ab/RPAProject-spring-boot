package rpa.backend.main.service;

import java.security.NoSuchAlgorithmException;

public interface UserService {
    boolean userCertificate(String email, String password) throws NoSuchAlgorithmException;
}
