package org.example;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    @NonNull
    private int id;
    private final String name;
    private final String surname;
    private final int age;
    private List<ServiceUsage> currentUsages = new ArrayList<>();
    private List<ServiceUsage> pastUsages = new ArrayList<>(); //storing history of this user's service usages

    public void startUsage(ServiceUsage serviceUsage) {
        currentUsages.add(serviceUsage);
    }

    public void finishUsage(ServiceUsage serviceUsage) {
        currentUsages.remove(serviceUsage);
        pastUsages.add(serviceUsage);
    }
}
