package com.barangay.services;

import com.barangay.models.Resident;
import com.barangay.models.TransactionLog;
import com.barangay.repositories.TransactionRepository;

import java.util.List;

public class ReportService {

    private final TransactionRepository repository;

    public ReportService(
            TransactionRepository repository) {

        this.repository = repository;
    }

    public void printTransactionReport() {
        List<TransactionLog> logs = repository.getAll();

        if (logs.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("Transaction Report:");
        for (TransactionLog log : logs) {
            System.out.println(log);
        }
    }

    public void printResidentReport(List<Resident> residents) {
        if (residents == null || residents.isEmpty()) {
            System.out.println("No residents found.");
            return;
        }

        System.out.println("Resident Report:");
        for (Resident resident : residents) {
            System.out.println(resident);
        }
    }
}
