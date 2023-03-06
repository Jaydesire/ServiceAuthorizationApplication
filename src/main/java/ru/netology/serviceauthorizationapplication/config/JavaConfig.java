package ru.netology.serviceauthorizationapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.serviceauthorizationapplication.UserRepository;
import ru.netology.serviceauthorizationapplication.service.AuthorizationService;

@Configuration
public class JavaConfig {

    @Bean
    public AuthorizationService authorizationService(UserRepository repository) {
        return new AuthorizationService(repository);
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}
