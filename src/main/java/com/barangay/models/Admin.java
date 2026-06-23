package com.barangay.models;

public class Admin extends Staff {

    public Admin(String employeeId,
                 String fullName) {

        super(employeeId, fullName);
    }

    @Override
    public void performDuty() {

        System.out.println(
                "Admin is managing the system."
        );
    }

    @Override
    public String toString() {

        return "Admin -> " +
                super.toString();
    }
}