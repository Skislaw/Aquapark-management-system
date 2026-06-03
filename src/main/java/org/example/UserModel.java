package org.example;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalTime;

@Data
public class UserModel {
    @NonNull
    private int id;
    private final String name;
    private final String surname;
    private final int age;
    private int usedServices = 0;
    private LocalTime startTime;
    private LocalTime finishTime;
}
