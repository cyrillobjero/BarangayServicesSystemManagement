package com.barangay.ui;

import java.util.Scanner;

public class MainMenu {

    public void display() {

        System.out.println("""
                ==========================
                BARANGAY SYSTEM
                ==========================
                1. Residents
                2. Requests
                3. Payments
                4. Reports
                0. Exit
                """);
    }

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            mainMenu.display();
            System.out.print("Select an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> new ResidentMenu().display();
                case "2" -> new RequestMenu().display();
                case "3" -> new PaymentMenu().display();
                case "4" -> new ReportMenu().display();
                case "0" -> {
                    System.out.println("Exiting application...");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }

            if (running) {
                System.out.println();
                System.out.print("Press Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
