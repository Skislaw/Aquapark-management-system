package org.example;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class CommandsService {
    //a class for interpreting and running commands
    private final BusinessService businessService;
    private final Scanner scanner;


    public String addService() {
            System.out.println("==== Adding service: ====\n");
            System.out.println("Service name: ");
            String name = scanner.nextLine();

            if (name.isEmpty()) {
                throw new IllegalArgumentException("Wrong value");
            }

            System.out.println("Service capacity: ");
            int capacity = Integer.parseInt(scanner.nextLine());

            if (capacity <= 0) {
                throw new IllegalArgumentException("Wrong value");
            }

            System.out.println("Service price (xx.yy per hour)");
            float price = Integer.parseInt(scanner.nextLine());

            if (price < 0) {
                throw new IllegalArgumentException("Wrong value");
            }

            ServiceType serviceType = new ServiceType(name, price, capacity);
            return  "Service " + businessService.addService(serviceType) + " has been added.";
    }

    public String addUser() {
        System.out.println("==== Adding user: ====\n");
        System.out.println("User name: ");
        String name = scanner.nextLine();

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Wrong value");
        }

        System.out.println("User surname: ");
        String surname = scanner.nextLine();

        if (surname.isEmpty()) {
            throw new IllegalArgumentException("Wrong value");
        }

        System.out.println("User age: ");
        int age = Integer.parseInt(scanner.nextLine());

        int id = 0;

        User user = new User(id, name, surname, age);
        User addedUser = businessService.addUser(user);

        return "User " + addedUser + " has been added.";
    }

    public void startService() {
        //start service

        System.out.println("==== Starting service: ====\n");

        System.out.println("User name: ");
        String name = scanner.nextLine();

        System.out.println("User surname: ");
        String surname = scanner.nextLine();

        List<User> foundUsers =
                businessService.findUserByNameAndSurname(name, surname);

        if (foundUsers.isEmpty()) {
            System.out.println("User not found");
            return;
        }

        if (foundUsers.size() > 1) {
            System.out.println("More than one users found. Choose one to continue:");
            for (int i = 0; i < foundUsers.size(); i++) {
                System.out.println((i + 1) + ": " + foundUsers.get(i));
            }

            int choose = Integer.parseInt(scanner.nextLine());

            if (choose < 1 || choose > foundUsers.size()) {
                System.out.println("Incorrect selection");
            }

            User user = foundUsers.get(choose - 1);


        }

        System.out.println("Service name: ");
        String serviceName = scanner.nextLine();

        try {
            businessService.findServiceTypeByName(serviceName);
        } catch (IllegalArgumentException exception) {
            System.out.println("User not found.");
            return;
        }

        ServiceType serviceType = businessService.findServiceTypeByName(serviceName);
    }
}