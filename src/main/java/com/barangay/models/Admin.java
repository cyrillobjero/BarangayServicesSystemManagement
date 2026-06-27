package com.barangay.models;

public class Admin extends Staff {

    public Admin(String staffId, String name) {
        super(staffId, name);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: ADMIN");
    }
}