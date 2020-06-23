package rpa.backend.main.service;

import org.springframework.stereotype.Service;
import rpa.backend.main.entity.Login;
import rpa.backend.main.entity.User;
import rpa.backend.main.repository.LoginRepository;
import rpa.backend.main.repository.UserRepository;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final LoginRepository loginRepository;

    public UserServiceImpl(UserRepository userRepository, LoginRepository loginRepository) {
        this.userRepository = userRepository;
        this.loginRepository = loginRepository;
    }

    @Override
    public boolean userCertificate(String email, String password) throws NoSuchAlgorithmException {
        Optional<User> userOptional = this.userRepository.findByEmail(email);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            Optional<Login> loginOptional = this.loginRepository.findByUser(user);
            if (loginOptional.isPresent()){
                Login login = loginOptional.get();
                return login.getPassword().equals(SHA256Algorithm.getHashedValue(password));
            }
        }
        return false;
    }
}
