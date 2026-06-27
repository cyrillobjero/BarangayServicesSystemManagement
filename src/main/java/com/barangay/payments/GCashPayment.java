package com.barangay.payments;

import com.barangay.interfaces.Payment;

public class GCashPayment implements Payment {

    @Override
    public boolean processPayment(double amount) {

        System.out.println(
                "GCash payment processed: ₱" + amount
        );
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "GCash";
    }
}
