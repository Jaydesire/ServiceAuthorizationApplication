package ru.netology.serviceauthorizationapplication.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.netology.serviceauthorizationapplication.Authorities;
import ru.netology.serviceauthorizationapplication.UserRepository;
import ru.netology.serviceauthorizationapplication.exceptions.InvalidCredentials;
import ru.netology.serviceauthorizationapplication.exceptions.UnauthorizedUser;

import java.util.List;
@Service
public class AuthorizationService {
    UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
