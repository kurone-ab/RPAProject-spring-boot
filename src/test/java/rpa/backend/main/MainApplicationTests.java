package rpa.backend.main;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rpa.backend.main.entity.User;
import rpa.backend.main.repository.UserRepository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MainApplicationTests {
    private final UserRepository userRepository;

    @Autowired
    MainApplicationTests(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void runtimeExe() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("key1", "value1");
        System.out.println(map.toString().replace("=", " : "));
    }

    @Test
    void checkUnique() {
        try {
            this.userRepository.save(User.builder().email("tt").build());
            this.userRepository.save(User.builder().email("tt").build());
        } catch (ConstraintViolationException e) {
            System.out.println("error");
        }
    }

}
