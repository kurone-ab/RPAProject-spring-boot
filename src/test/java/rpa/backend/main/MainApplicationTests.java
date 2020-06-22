package rpa.backend.main;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MainApplicationTests {

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

}
