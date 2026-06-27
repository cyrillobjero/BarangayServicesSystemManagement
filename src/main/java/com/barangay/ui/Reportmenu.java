package com.barangay.ui;

import com.barangay.models.Resident;
import com.barangay.services.ReportService;
import com.barangay.services.ResidentService;

import java.util.Scanner;

public class ReportMenu {

    private final Scanner scanner;
    private final ReportService reportService;
    private final ResidentService residentService;

    public ReportMenu(Scanner scanner,
                      ReportService reportService,
                      ResidentService residentService) {

        this.scanner = scanner;
        this.reportService = reportService;
        this.residentService = residentService;
    }

    public void display() {
        boolean running = true;

        while (running) {
            System.out.println(
                    "==========================\n" +
                    "REPORT MENU\n" +
                    "==========================\n" +
                    "1. Transaction Report\n" +
                    "2. Resident Report\n" +
                    "0. Back to Main Menu\n"
            );

            System.out.print("Select an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    reportService.printTransactionReport();
                    break;
                case "2":
                    reportService.printResidentReport(residentService.getAllResidents());
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
