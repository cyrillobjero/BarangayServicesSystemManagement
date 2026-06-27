package com.barangay.ui;

import com.barangay.models.Resident;
import com.barangay.services.ResidentService;

import java.util.Scanner;

public class ResidentMenu {

    private final Scanner scanner;
    private final ResidentService residentService;

    public ResidentMenu(Scanner scanner,
                        ResidentService residentService) {

        this.scanner = scanner;
        this.residentService = residentService;
    }

    public void display() {
        boolean running = true;

        while (running) {
            System.out.println(
                    "==========================\n" +
                    "RESIDENT MENU\n" +
                    "==========================\n" +
                    "1. Add Resident\n" +
                    "2. View Residents\n" +
                    "0. Back to Main Menu\n"
            );

            System.out.print("Select an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addResident();
                    break;
                case "2":
                    viewResidents();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            if (running) {
                System.out.println();
            }
        }
    }

    private void addResident() {
        System.out.print("Resident ID: ");
        String residentId = scanner.nextLine().trim();

        System.out.print("First name: ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Last name: ");
        String lastName = scanner.nextLine().trim();

        System.out.print("Age: ");
        String ageInput = scanner.nextLine().trim();
        int age;
        try {
            age = Integer.parseInt(ageInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid age. Resident was not added.");
            return;
        }

        System.out.print("Address: ");
        String address = scanner.nextLine().trim();

        Resident resident = new Resident(
                residentId,
                firstName,
                lastName,
                age,
                address
        );

        residentService.registerResident(resident);
        System.out.println("Resident added successfully.");
    }

    private void viewResidents() {
        if (residentService.getAllResidents().isEmpty()) {
            System.out.println("No residents found.");
            return;
        }

        for (Resident resident : residentService.getAllResidents()) {
            System.out.println(resident);
        }
    }
}
