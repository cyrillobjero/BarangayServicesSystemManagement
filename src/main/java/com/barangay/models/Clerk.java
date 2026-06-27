package com.barangay.models;

public class Clerk extends Staff {

    public Clerk(String staffId, String name) {
        super(staffId, name);
    }

    @Override
    public void performDuty() {
        System.out.println("Clerk is assisting residents.");
    }
}