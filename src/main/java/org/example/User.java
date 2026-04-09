package org.example;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalTime;

@Data
public class User {
    @NonNull
    private int id;
    private final String name;
    private final String surname;
    private final int age;
    private LocalTime startTime;
    private LocalTime finishTime;
}
