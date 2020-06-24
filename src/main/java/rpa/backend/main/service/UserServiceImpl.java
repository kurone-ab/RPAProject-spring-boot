package rpa.backend.main.service;

import org.springframework.stereotype.Service;
import rpa.backend.main.dto.UserDTO;
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
    public UserDTO userCertificate(String email, String password) throws NoSuchAlgorithmException {
        Optional<User> userOptional = this.userRepository.findByEmail(email);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            if (!user.isAuthenticated()) return UserDTO.builder().error("이메일 인증이 완료되지 않은 사용자입니다.").build();
            Optional<Login> loginOptional = this.loginRepository.findByUser(user);
            if (loginOptional.isPresent()){
                Login login = loginOptional.get();
                if (login.getPassword().equals(SHA256Algorithm.getHashedValue(password))) {
                    return UserDTO.builder().id(user.getId()).name(user.getName()).auth(user.getAuth().name()).build();
                } else {
                    return UserDTO.builder().error("비밀번호를 다시 확인하세요.").build();
                }
            } else return UserDTO.builder().error("존재하지 않는 사용자입니다.").build();
        }
        return UserDTO.builder().build();
    }
}
