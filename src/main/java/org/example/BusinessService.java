package org.example;

import lombok.AllArgsConstructor;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
public class BusinessService {
    private UsersRepository usersRepository;
    private ServicesRepository servicesRepository;

    public UserModel addUser(UserModel userModel) {
        return usersRepository.addUser(userModel);
    }

    public ServiceModel addService(ServiceModel serviceModel) {
        return servicesRepository.addService(serviceModel);
    }

    public void startService(UserModel userModel, ServiceModel serviceModel) {
        LocalTime startTime = LocalTime.now();

        ServiceUsage serviceUsage = new ServiceUsage(userModel, serviceModel, startTime);
    }

    public float finishService(ServiceUsage serviceUsage, UserModel userModel) {
        LocalTime startTime = serviceUsage.getStartTime();
        LocalTime finishTime = LocalTime.now();
        serviceUsage.setFinishTime(finishTime);
        ServiceModel serviceModel = serviceUsage.getServiceModel();

        long timeDuration = ChronoUnit.MINUTES.between(startTime, finishTime);
        return timeDuration * serviceModel.getPrice();
    }
}
