package org.example;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
public class ServiceType {
    //defines what type of service it is (aquapark, sports swimming pool, sauna etc.)

    private int id;
    private final String name;
    private final float price; //per hour
    @NonNull
    private int capacity;
}
