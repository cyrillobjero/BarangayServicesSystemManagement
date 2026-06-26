package com.barangay.utils;

public class InputValidator {

    public static boolean isBlank(
            String value) {

        return value == null ||
               value.isBlank();
    }

    public static boolean isValidAge(
            int age) {

        return age >= 0;
    }
}
