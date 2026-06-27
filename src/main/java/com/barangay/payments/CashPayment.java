package com.barangay.payments;

import com.barangay.interfaces.Payment;

public class CashPayment implements Payment {

    @Override
    public boolean processPayment(double amount) {

        System.out.println(
                "Cash payment received: ₱" + amount
        );
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Cash";
    }
}