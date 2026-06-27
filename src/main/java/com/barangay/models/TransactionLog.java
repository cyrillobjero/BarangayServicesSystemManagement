package com.barangay.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionLog
        implements Comparable<TransactionLog> {

    private String transactionId;
    private String description;
    private LocalDateTime timestamp;

    public TransactionLog(String transactionId,
                          String description) {

        setTransactionId(transactionId);
        setDescription(description);

        this.timestamp = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {

        if (transactionId == null ||
                transactionId.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Transaction ID cannot be empty.");
        }

        this.transactionId = transactionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {

        if (description == null ||
                description.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Description cannot be empty.");
        }

        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public int compareTo(TransactionLog other) {
        return this.timestamp.compareTo(
                other.timestamp);
    }

    @Override
    public String toString() {
        return transactionId +
                " | " +
                description +
                " | " +
                timestamp;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof TransactionLog))
            return false;

        TransactionLog log = (TransactionLog) obj;
        return transactionId.equals(
                log.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId);
    }
}
