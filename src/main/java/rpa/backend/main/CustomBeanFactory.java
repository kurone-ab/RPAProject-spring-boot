package rpa.backend.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.security.SecureRandom;

@Configuration
public class CustomBeanFactory {
    @Bean
    //랜덤함수를 부르기 위한 인스턴스 생성
    public SecureRandom random() {
        SecureRandom random = new SecureRandom();
        random.setSeed(System.currentTimeMillis());
        return random;
    }
}
