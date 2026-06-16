package org.example;

import lombok.Data;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class ServicesRepository {
    //a "database" class storing data of in-use-services

    private List<ServiceType> servicesList = new ArrayList<>();
    private int nextId = 0;

    public ServiceType addService(ServiceType serviceType) {
        serviceType.setId(nextId++);
        servicesList.add(serviceType);
        return serviceType;
    }

    public ServiceType removeService(ServiceType serviceType) {
        servicesList.remove(serviceType);
        return serviceType;
    }

    public Optional<ServiceType> findServiceById(int id) {
        return servicesList.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }

    public Optional<ServiceType> findServiceByName(String name) {
        return servicesList.stream()
                .filter(u -> u.getName().equals(name))
                .findFirst();
    }

    void asd(String name) {
        try {
            findServiceByName(name);
        } catch (RuntimeException e) {
            System.out.println("błont.");
        }
    }

}

