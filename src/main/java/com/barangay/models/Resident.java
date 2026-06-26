package com.barangay.models;

import java.util.Objects;

public class Resident {

    private String residentId;
    private String firstName;
    private String lastName;
    private int age;
    private String address;

    public Resident(String residentId,
                    String firstName,
                    String lastName,
                    int age,
                    String address) {

        setResidentId(residentId);
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setAddress(address);
    }

    public String getResidentId() {
        return residentId;
    }

    public void setResidentId(String residentId) {
        if (residentId == null || residentId.isBlank()) {
            throw new IllegalArgumentException(
                    "Resident ID cannot be empty.");
        }
        this.residentId = residentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException(
                    "First name cannot be empty.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException(
                    "Last name cannot be empty.");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(
                    "Age cannot be negative.");
        }
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException(
                    "Address cannot be empty.");
        }
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format(
                "[%s] %s %s | Age: %d | Address: %s",
                residentId,
                firstName,
                lastName,
                age,
                address
        );
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Resident resident)) {
            return false;
        }

        return Objects.equals(
                residentId,
                resident.residentId
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(residentId);
    }
}
