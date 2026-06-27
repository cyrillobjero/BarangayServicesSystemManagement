package com.barangay;

import com.barangay.models.Resident;
import com.barangay.models.TransactionLog;

import com.barangay.payments.CashPayment;
import com.barangay.payments.GCashPayment;
import com.barangay.payments.CardPayment;

import com.barangay.repositories.ResidentRepository;
import com.barangay.repositories.RequestRepository;
import com.barangay.repositories.TransactionRepository;

import com.barangay.requests.DocumentRequest;
import com.barangay.requests.BarangayService;

import com.barangay.services.PaymentService;
import com.barangay.services.ReportService;
import com.barangay.services.RequestService;
import com.barangay.services.ResidentService;

import com.barangay.ui.MainMenu;

public class Main {

    public static void main(String[] args) {

        MainMenu menu = new MainMenu();
        menu.display();

        ResidentRepository residentRepository =
                new ResidentRepository();

        RequestRepository requestRepository =
                new RequestRepository();

        TransactionRepository transactionRepository =
                new TransactionRepository();

        ResidentService residentService =
                new ResidentService(residentRepository);

        RequestService requestService =
                new RequestService(requestRepository);

        PaymentService paymentService =
                new PaymentService();

        ReportService reportService =
                new ReportService(transactionRepository);

        Resident resident1 = new Resident(
                "R001",
                "Mary",
                "Cruz",
                20,
                "Barangay Del Monte"
        );

        Resident resident2 = new Resident(
                "R002",
                "Jack",
                "Santos",
                30,
                "Barangay Bell"
        );

        residentService.registerResident(resident1);
        residentService.registerResident(resident2);

        System.out.println("\nResidents:");
        residentService.getAllResidents()
                .forEach(System.out::println);

        BarangayService request =
                new DocumentRequest(
                        "REQ001",
                        "R001",
                        "Barangay Clearance"
                );

        request.processRequest();

        requestService.submitRequest(request);

        System.out.println("\nRequest:");
        System.out.println(
                requestService.findRequest("REQ001")
        );

        System.out.println("\nPayments:");

        paymentService.pay(new CashPayment(), 120);

        paymentService.pay(new GCashPayment(), 190);

        paymentService.pay(new CardPayment(), 270);

        transactionRepository.add(
                new TransactionLog(
                        "TR001",
                        "Resident Registered"
                )
        );

        transactionRepository.add(
                new TransactionLog(
                        "TR002",
                        "Document Request Submitted"
                )
        );

        transactionRepository.add(
                new TransactionLog(
                        "TR003",
                        "Payment Received"
                )
        );

        System.out.println("\nTransaction Report:");
        reportService.printTransactions();
    }
}