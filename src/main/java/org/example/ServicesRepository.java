package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class ServicesRepository{
    //a "database" class storing services data
    private List<ServiceModel> servicesList = new ArrayList<>();
    private int nextId = 0;

    private ServiceModel addServices(ServiceModel serviceModel) {
        serviceModel.setId(nextId++);
        servicesList.add(serviceModel);
        return serviceModel;
    }

    public Optional<ServiceModel> findUserById(int id) {
        return servicesList.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }

    public void start(ServiceModel serviceModel) {
        serviceModel.setFree(false);
    }

}
