package ru.netology.serviceauthorizationapplication;

import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        return new ArrayList<>();
    }
}
