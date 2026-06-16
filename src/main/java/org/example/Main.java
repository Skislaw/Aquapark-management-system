package org.example;


import java.util.Scanner;

public class Main {
    static void main() {
        UsersRepository usersRepository = new UsersRepository();
        ServicesRepository servicesRepository = new ServicesRepository();
        ServiceUsageRepository serviceUsageRepository = new ServiceUsageRepository();
        Scanner scanner = new Scanner(System.in);
        BusinessService businessService = new BusinessService(usersRepository, servicesRepository, serviceUsageRepository);
        CommandsService commandsService = new CommandsService(businessService, scanner);
        CliManager cliManager = new CliManager(businessService, commandsService);

        cliManager.runner();
    }

}
