package com.barangay.services;

public class ValidationService {

    public boolean isValidString(
            String value) {

        return value != null &&
               !value.trim().isEmpty();
    }

    public boolean isValidAge(
            int age) {

        return age >= 0;
    }
}
