package com.barangay.ui;

import com.barangay.repositories.ResidentRepository;
import com.barangay.repositories.RequestRepository;
import com.barangay.repositories.TransactionRepository;
import com.barangay.services.PaymentService;
import com.barangay.services.ReportService;
import com.barangay.services.RequestService;
import com.barangay.services.ResidentService;

import java.util.Scanner;

public class MainMenu {

    private final Scanner scanner;
    private final ResidentService residentService;
    private final RequestService requestService;
    private final ReportService reportService;
    private final PaymentService paymentService;

    public MainMenu() {
        this.scanner = new Scanner(System.in);
        ResidentRepository residentRepository = new ResidentRepository();
        RequestRepository requestRepository = new RequestRepository();
        TransactionRepository transactionRepository = new TransactionRepository();

        this.residentService = new ResidentService(residentRepository);
        this.requestService = new RequestService(requestRepository);
        this.reportService = new ReportService(transactionRepository);
        this.paymentService = new PaymentService();
    }

    public void display() {
        boolean running = true;

        while (running) {
            System.out.println(
                    "==========================\n" +
                    "BARANGAY SYSTEM\n" +
                    "==========================\n" +
                    "1. Residents\n" +
                    "2. Requests\n" +
                    "3. Payments\n" +
                    "4. Reports\n" +
                    "0. Exit\n"
            );

            System.out.print("Select an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    new ResidentMenu(scanner, residentService).display();
                    break;
                case "2":
                    new RequestMenu(scanner, requestService).display();
                    break;
                case "3":
                    new PaymentMenu(scanner, paymentService).display();
                    break;
                case "4":
                    new ReportMenu(scanner, reportService, residentService).display();
                    break;
                case "0":
                    System.out.println("Exiting application...");
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

        scanner.close();
    }
}
