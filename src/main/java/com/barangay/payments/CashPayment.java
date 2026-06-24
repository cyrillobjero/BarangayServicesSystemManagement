package com.barangay.payments;

import com.barangay.interfaces.Payment;

public class CashPayment implements Payment {

    @Override
    public void processPayment(double amount) {

        System.out.println(
                "Cash payment received: ₱" + amount
        );
    }
}