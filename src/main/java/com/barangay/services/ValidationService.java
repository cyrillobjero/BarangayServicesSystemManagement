package com.barangay.services;

public class ValidationService {

    public boolean isValidString(
            String value) {

        return value != null &&
               !value.isBlank();
    }

    public boolean isValidAge(
            int age) {

        return age >= 0;
    }
}
