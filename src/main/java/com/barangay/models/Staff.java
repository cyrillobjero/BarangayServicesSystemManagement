package com.barangay.models;

import java.util.Objects;

public abstract class Staff {

    private String staffId;
    private String name;

    public Staff(String staffId, String name) {

        setStaffId(staffId);
        setName(name);
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {

        if (staffId == null || staffId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Staff ID cannot be empty.");
        }

        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Name cannot be empty.");
        }

        this.name = name;
    }

    public abstract void displayRole();

    @Override
    public String toString() {
        return staffId + " - " + name;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Staff))
            return false;

        Staff staff = (Staff) obj;
        return staffId.equals(staff.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId);
    }
}
