package org.example;

import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
    //A "database" class storing users data

    private final List<User> usersList = new ArrayList<>();
    private int nextId = 0;

    public User addUser(User user) {
        user.setId(nextId++);
        usersList.add(user);
        return user;
    }


    public User removeUser(User user) {
        usersList.remove(user);
        return user;
    }

    public User findUserById(int id) {
        return usersList.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public List<User> findUserByNameAndSurname(String name, String surname) {
         return usersList.stream()
                .filter(u -> u.getName().equals(name) && u.getSurname().equals(surname))
                .toList();
    }
}
