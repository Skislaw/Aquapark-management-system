package org.example;

import lombok.Data;

@Data
public class User {
    private final int id;
    private final String name;
    private final String surname;
    private final int age;
}
