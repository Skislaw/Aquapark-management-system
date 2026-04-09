package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepository {
    //A "database" class storing users data

    private final List<User> usersList = new ArrayList<>();
    private int nextId = 0;

    public User addUser(User user) {
        user.setId(nextId++);
        usersList.add(user);
        return user;
    }

    public Optional<User> findUserById(int id) {
        return usersList.stream()
                .filter(u -> u.getId() == id)
                .findFirst();


    }

}
