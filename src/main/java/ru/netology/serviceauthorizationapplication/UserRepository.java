package ru.netology.serviceauthorizationapplication;

import ru.netology.serviceauthorizationapplication.exceptions.UnauthorizedUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    final private Map<String, User> users = new HashMap<>();

    public UserRepository() {
        //localhost:8080/authorize?user=user1&password=pass1
        users.put("user1", new User("user1", "pass1", Authorities.READ));
        users.put("user2", new User("user2", "pass2", Authorities.READ, Authorities.WRITE));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if(!users.containsKey(user)) {
            throw new UnauthorizedUser("Unknown user");
        }
        if(!users.get(user).getPassword().equals(password)) {
            throw new UnauthorizedUser("Wrong password");
        }
        return users.get(user).getAuthorities();
    }
}
