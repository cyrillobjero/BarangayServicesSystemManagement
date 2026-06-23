package com.barangay.models;

import java.util.Objects;

public abstract class Staff {

    private String employeeId;
    private String fullName;

    public Staff(String employeeId,
                 String fullName) {

        setEmployeeId(employeeId);
        setFullName(fullName);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {

        if (employeeId == null ||
                employeeId.isBlank()) {

            throw new IllegalArgumentException(
                    "Employee ID cannot be empty.");
        }

        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {

        if (fullName == null ||
                fullName.isBlank()) {

            throw new IllegalArgumentException(
                    "Full name cannot be empty.");
        }

        this.fullName = fullName;
    }

    public abstract void performDuty();

    @Override
    public String toString() {
        return String.format(
                "Employee ID: %s | Name: %s",
                employeeId,
                fullName
        );
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Staff staff)) {
            return false;
        }

        return Objects.equals(
                employeeId,
                staff.employeeId
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}
