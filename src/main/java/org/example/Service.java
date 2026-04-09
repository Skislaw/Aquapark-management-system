package org.example;

import lombok.AllArgsConstructor;
import org.example.Buyable.Purchasable;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@AllArgsConstructor
public class Service {
    private UsersRepository usersRepository = new UsersRepository();
    private ServicesRepository servicesRepository = new ServicesRepository();

    public User addUser(User user) {
        return usersRepository.addUser(user);
    }

    public Optional<User> getUserById(int id) {
         return usersRepository.findUserById(id);
    }

    public String startService(Purchasable service, int id) {
        Optional<User> optionalUser = usersRepository.findUserById(id);

        if (optionalUser.isEmpty()) {
            return "User not found";
        }

        User user = optionalUser.orElse(null);
        user.setStartTime(LocalTime.now());

        service.start(user);
        return "Service has been purchased.";
    }

    public String finishService(int id) {
        Optional<User> optionalUser = usersRepository.findUserById(id);

        if (optionalUser.isEmpty()) {
            return "User not found";
        }

        User user = optionalUser.orElse(null);

        LocalTime startTime = user.getStartTime();
        LocalTime finishtime = LocalTime.now();
        user.setFinishTime(finishtime);

        long timeDuration = ChronoUnit.MINUTES.between(startTime, finishtime);
        return "Hello world.";
    }
}
