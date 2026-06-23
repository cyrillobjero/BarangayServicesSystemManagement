package com.barangay.requests;

import com.barangay.models.ServiceStatus;

public class ClearanceRequest extends BarangayService {

    private String purpose;

    public ClearanceRequest(String requestId,
                            String residentId,
                            String purpose) {

        super(requestId, residentId);
        this.purpose = purpose;
    }

    public String getPurpose() {
        return purpose;
    }

    @Override
    public void processRequest() {
        updateStatus(ServiceStatus.APPROVED);
    }

    @Override
    public String toString() {
        return "ClearanceRequest{" +
                "requestId='" + getRequestId() + '\'' +
                ", residentId='" + getResidentId() + '\'' +
                ", purpose='" + purpose + '\'' +
                ", status=" + getStatus() +
                '}';
    }
}