package com.barangay.payments;

import com.barangay.interfaces.Payment;

public class GCashPayment implements Payment;

public class GCashPayment implements Payment {

    @Override
    public void processPayment(double amount) {

        System.out.println(
                "GCash payment processed: ₱" + amount
        );
    }
}
