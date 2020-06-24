package rpa.backend.main.service;

import rpa.backend.main.dto.UserDTO;

import java.security.NoSuchAlgorithmException;

public interface UserService {
    UserDTO userCertificate(String email, String password) throws NoSuchAlgorithmException;
}
