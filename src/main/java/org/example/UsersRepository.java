package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepository {
    //A "database" class storing users data

    private final List<UserModel> usersList = new ArrayList<>();
    private int nextId = 0;

    public UserModel addUser(UserModel userModel) {
        userModel.setId(nextId++);
        usersList.add(userModel);
        return userModel;
    }


    public UserModel removeUser(UserModel userModel) {
        usersList.remove(userModel);
        return userModel;
    }

    public UserModel findUserById(int id) {
        return usersList.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        }
    }
