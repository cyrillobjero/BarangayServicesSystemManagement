package com.barangay.models;

public class Clerk extends Staff {

    public Clerk(String staffId, String name) {
        super(staffId, name);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: CLERK");
    }
}