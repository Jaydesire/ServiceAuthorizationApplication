package ru.netology.serviceauthorizationapplication;

import java.util.Arrays;
import java.util.List;

public class User {
    private String user;
    private String password;
    private List<Authorities> authorities;

    public User(String user, String password, Authorities ... authorities) {
        this.user = user;
        this.password = password;
        this.authorities = Arrays.stream(authorities).toList();
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }


}
