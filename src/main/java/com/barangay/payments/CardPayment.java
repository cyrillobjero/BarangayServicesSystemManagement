package com.barangay.payments;

import com.barangay.interfaces.Payment;

public class CardPayment implements Payment {

    @Override
    public boolean processPayment(double amount) {

        System.out.println(
                "Card payment processed: ₱" + amount
        );
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Card";
    }
}


