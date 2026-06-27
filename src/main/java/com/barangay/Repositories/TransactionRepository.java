package com.barangay.repositories;

import com.barangay.interfaces.Searchable;
import com.barangay.models.TransactionLog;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository
        implements GenericRepository<TransactionLog>,
                   Searchable<TransactionLog> {

    private final List<TransactionLog> transactions;

    public TransactionRepository() {
        transactions = new ArrayList<>();
    }

    @Override
    public void add(TransactionLog transaction) {
        transactions.add(transaction);
    }

    @Override
    public void remove(TransactionLog transaction) {
        transactions.remove(transaction);
    }

    @Override
    public List<TransactionLog> getAll() {
        return new ArrayList<>(transactions);
    }

    public TransactionLog searchById(String id) {

        for (TransactionLog transaction : transactions) {

            if (transaction.getTransactionId()
                    .equalsIgnoreCase(id)) {

                return transaction;
            }
        }

        return null;
    }

    @Override
    public List<TransactionLog> search(String keyword) {
        List<TransactionLog> results = new ArrayList<>();

        for (TransactionLog transaction : transactions) {
            if (transaction.getTransactionId().equalsIgnoreCase(keyword)
                    || transaction.getDescription().equalsIgnoreCase(keyword)) {
                results.add(transaction);
            }
        }

        return results;
    }
}