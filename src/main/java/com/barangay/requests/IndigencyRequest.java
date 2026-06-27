package com.barangay.requests;

import com.barangay.models.ServiceStatus;

public class IndigencyRequest
        extends BarangayService {

    private String purpose;

    public IndigencyRequest(
            String requestId,
            String residentId,
            String purpose) {

        super(requestId, residentId);
        this.purpose = purpose;
    }

    @Override
    public void processRequest() {

        updateStatus(ServiceStatus.APPROVED);
    }

    @Override
    public String toString() {

        return "IndigencyRequest{" +
                "requestId='" + getRequestId() + '\'' +
                ", residentId='" + getResidentId() + '\'' +
                ", purpose='" + purpose + '\'' +
                ", status=" + getStatus() +
                '}';
    }
}