package rpa.backend.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.security.SecureRandom;

@Configuration
public class CustomBeanFactory {
    @Bean
    public SecureRandom random() {
        SecureRandom random = new SecureRandom();
        random.setSeed(System.currentTimeMillis());
        return random;
    }
}
