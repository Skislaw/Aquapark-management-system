package org.example;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class CliManager {
    private boolean shouldRun = true;
    private final BusinessService businessService;
    private final CommandsService commandsService;
    private final Scanner scanner = new Scanner(System.in);

    void runner() {
        System.out.println("====] HELLO AND WELCOME TO OUR PRODUCT [====\n\n");
        System.out.println("Type 'help' for commands list.");

        while (shouldRun) {
            String userInput = scanner.nextLine().toLowerCase();

            switch (userInput) {
                case "1" -> {
                    System.out.println(commandsService.addService());
                }

                case "2" -> {
                    commandsService.addUser();
                }

                case "3" -> {

                }

                case "4" -> shouldRun = false;


                default -> System.out.println("Unknown command. Please, try again.");

            }
        }
    }
}
