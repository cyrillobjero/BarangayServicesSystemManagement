package com.barangay.ui;

import com.barangay.exceptions.PaymentProcessingException;
import com.barangay.payments.CardPayment;
import com.barangay.payments.CashPayment;
import com.barangay.payments.GCashPayment;
import com.barangay.services.PaymentService;

import java.util.Scanner;

public class PaymentMenu {

    private final Scanner scanner;
    private final PaymentService paymentService;

    public PaymentMenu(Scanner scanner,
                       PaymentService paymentService) {

        this.scanner = scanner;
        this.paymentService = paymentService;
    }

    public void display() {
        boolean running = true;

        while (running) {
            System.out.println(
                    "==========================\n" +
                    "PAYMENT MENU\n" +
                    "==========================\n" +
                    "1. Cash Payment\n" +
                    "2. GCash Payment\n" +
                    "3. Card Payment\n" +
                    "0. Back to Main Menu\n"
            );

            System.out.print("Select an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    processPayment(new CashPayment());
                    break;
                case "2":
                    processPayment(new GCashPayment());
                    break;
                case "3":
                    processPayment(new CardPayment());
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

    private void processPayment(com.barangay.interfaces.Payment paymentMethod) {
        System.out.print("Amount: ");
        String amountInput = scanner.nextLine().trim();
        double amount;
        try {
            amount = Double.parseDouble(amountInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Payment cancelled.");
            return;
        }

        try {
            paymentService.pay(paymentMethod, amount);
        } catch (PaymentProcessingException e) {
            System.out.println("Payment error: " + e.getMessage());
        }
    }
}

