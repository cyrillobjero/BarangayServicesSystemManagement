package com.barangay.services;

import com.barangay.models.TransactionLog;
import com.barangay.repositories.TransactionRepository;

import java.util.List;

public class ReportService {

    private final TransactionRepository repository;

    public ReportService(
            TransactionRepository repository) {

        this.repository = repository;
    }

    public void printTransactions() {

        List<TransactionLog> logs =
                repository.getAll();

        for (TransactionLog log : logs) {

            System.out.println(log);
        }
    }
}
