package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class ServicesRepository {
    //a "database" class storing services data

    private List<ServiceModel> servicesList = new ArrayList<>();
    private int nextId = 0;

    public ServiceModel addService(ServiceModel serviceModel) {
        serviceModel.setId(nextId++);
        servicesList.add(serviceModel);
        return serviceModel;
    }

    public ServiceModel removeService(ServiceModel serviceModel) {
        servicesList.remove(serviceModel);
        return serviceModel;
    }

    public ServiceModel findServiceById(int id) {
        return servicesList.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Service not found"));
    }
}
