package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ServiceUsageRepository {
    //A "database" class storing serviceUsages data

    @Getter
    private final List<ServiceUsage> serviceUsageList = new ArrayList<>();
    private int nextId = 0;

    public ServiceUsage addServiceUsage(ServiceUsage serviceUsage) {
        serviceUsage.setId(nextId++);
        serviceUsageList.add(serviceUsage);
        return serviceUsage;
    }


    public ServiceUsage removeServiceUsage(ServiceUsage serviceUsage) {
        serviceUsageList.remove(serviceUsage);
        return serviceUsage;
    }

    public ServiceUsage findServiceUsageById(int id) {
        return serviceUsageList.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Service usage not found"));

    }

    public ServiceUsage findServiceUsageByUserId(int id) {
        return serviceUsageList.stream()
                .filter(u -> u.getUser().getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Service usage not found"));

    }

}
