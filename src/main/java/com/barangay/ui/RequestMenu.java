package com.barangay.ui;

import com.barangay.requests.BarangayService;
import com.barangay.requests.ClearanceRequest;
import com.barangay.requests.DocumentRequest;
import com.barangay.requests.IndigencyRequest;
import com.barangay.services.RequestService;

import java.util.Scanner;

public class RequestMenu {

    private final Scanner scanner;
    private final RequestService requestService;

    public RequestMenu(Scanner scanner,
                       RequestService requestService) {

        this.scanner = scanner;
        this.requestService = requestService;
    }

    public void display() {
        boolean running = true;

        while (running) {
            System.out.println(
                    "==========================\n" +
                    "REQUEST MENU\n" +
                    "==========================\n" +
                    "1. Submit Request\n" +
                    "2. Track Request\n" +
                    "0. Back to Main Menu\n"
            );

            System.out.print("Select an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    submitRequest();
                    break;
                case "2":
                    trackRequest();
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

    private void submitRequest() {
        System.out.println("Select request type:");
        System.out.println("1. Document Request");
        System.out.println("2. Clearance Request");
        System.out.println("3. Indigency Request");
        System.out.print("Type: ");
        String requestType = scanner.nextLine().trim();

        System.out.print("Request ID: ");
        String requestId = scanner.nextLine().trim();

        System.out.print("Resident ID: ");
        String residentId = scanner.nextLine().trim();

        System.out.print("Purpose / Document type: ");
        String description = scanner.nextLine().trim();

        BarangayService request;
        switch (requestType) {
            case "2":
                request = new ClearanceRequest(requestId, residentId, description);
                break;
            case "3":
                request = new IndigencyRequest(requestId, residentId, description);
                break;
            default:
                request = new DocumentRequest(requestId, residentId, description);
                break;
        }

        request.processRequest();
        requestService.submitRequest(request);
        System.out.println("Request submitted successfully.");
    }

    private void trackRequest() {
        System.out.print("Request ID: ");
        String requestId = scanner.nextLine().trim();

        BarangayService request = requestService.findRequest(requestId);
        if (request == null) {
            System.out.println("Request not found.");
            return;
        }

        System.out.println(request);
    }
}
