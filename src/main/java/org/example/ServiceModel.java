package org.example;

import lombok.Data;

@Data
public class ServiceModel {
    private int id;
    private final String name;
    private final float price; //per hour
    private int capacity;
}
