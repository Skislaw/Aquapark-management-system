package org.example;

import lombok.AllArgsConstructor;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@AllArgsConstructor
public class BusinessService {

    private UsersRepository usersRepository;
    private ServicesRepository servicesRepository;
    private ServiceUsageRepository serviceUsageRepository;

    public User addUser(User user) {
        return usersRepository.addUser(user);
    }

    public ServiceType addService(ServiceType serviceType) {
        return servicesRepository.addService(serviceType);
    }

    public User removeUser(User user) {
        return usersRepository.removeUser(user);
    }

    public ServiceType removeService(ServiceType serviceType) {
        return servicesRepository.removeService(serviceType);
    }

    public void startService(User user, ServiceType serviceType) {

        LocalTime startTime = LocalTime.now();
        ServiceUsage serviceUsage = new ServiceUsage(user, serviceType, startTime);
        user.startUsage(serviceUsage);
    }

    public float finishService(ServiceUsage serviceUsage, User user) {
        LocalTime startTime = serviceUsage.getStartTime();
        LocalTime finishTime = LocalTime.now();
        serviceUsage.setFinishTime(finishTime);

        ServiceType serviceType = serviceUsage.getServiceType();
        user.finishUsage(serviceUsage);

        long timeDuration = ChronoUnit.MINUTES.between(startTime, finishTime);
        return timeDuration * serviceType.getPrice();
    }

    public User findUserById(int id) {
        return usersRepository.findUserById(id);
    }

    public List<User> findUserByNameAndSurname(String name, String surname) {
        List<User> foundUsers = usersRepository.findUserByNameAndSurname(name, surname);

        if (foundUsers.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        return foundUsers;


    }

    public ServiceType findServiceTypeByName(String name) {
        return servicesRepository
                .findServiceByName(name)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
