package org.example;

import lombok.AllArgsConstructor;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@AllArgsConstructor
public class BusinessService {
    private UsersRepository usersRepository;
    private ServicesRepository servicesRepository;

    public UserModel addUser(UserModel userModel) {
        return usersRepository.addUser(userModel);
    }

    public Optional<UserModel> getUserById(int id) {
         return usersRepository.findUserById(id);
    }

    public String startService(ServiceModel serviceModel, int id) {
        Optional<UserModel> optionalUser = usersRepository.findUserById(id);

        if (optionalUser.isEmpty()) {
            return "User not found";
        }

        UserModel userModel = optionalUser.orElse(null);
        userModel.setStartTime(LocalTime.now());

        servicesRepository.start(serviceModel);
        usersRepository.start(userModel);
        return "Service has been purchased.";
    }

    public String finishService(ServiceModel serviceModel, UserModel userModel) {
        LocalTime startTime = userModel.getStartTime();
        LocalTime finishTime = LocalTime.now();
        userModel.setFinishTime(finishTime);

        long timeDuration = ChronoUnit.MINUTES.between(startTime, finishTime);
        float price = timeDuration * serviceModel.getPrice();
        return "Final price: " + price;
    }
}
