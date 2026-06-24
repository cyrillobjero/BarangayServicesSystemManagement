package com.barangay.services;

import com.barangay.interfaces.Payment;

public class PaymentService {

    public void pay(
            Payment paymentMethod,
            double amount) {

        paymentMethod.processPayment(amount);
    }
}

