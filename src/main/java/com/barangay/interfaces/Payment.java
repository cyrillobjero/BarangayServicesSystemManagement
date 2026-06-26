package com.barangay.interfaces;

import com.barangay.exceptions.PaymentProcessingException;

public interface Payment {

    boolean processPayment(double amount)
            throws PaymentProcessingException;

    String getPaymentMethod();
}