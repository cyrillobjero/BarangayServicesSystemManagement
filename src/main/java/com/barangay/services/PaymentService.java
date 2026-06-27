package com.barangay.services;

import com.barangay.exceptions.PaymentProcessingException;
import com.barangay.interfaces.Payment;

public class PaymentService {

    public void pay(
            Payment paymentMethod,
            double amount)
            throws PaymentProcessingException {

        paymentMethod.processPayment(amount);
    }
}

