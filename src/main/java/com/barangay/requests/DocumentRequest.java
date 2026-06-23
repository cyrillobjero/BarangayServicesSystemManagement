package com.barangay.requests;

import com.barangay.models.ServiceStatus;

public class DocumentRequest extends BarangayService {

    private String documentType;

    public DocumentRequest(String requestId,
                           String residentId,
                           String documentType) {

        super(requestId, residentId);
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }

    @Override
    public void processRequest() {
        updateStatus(ServiceStatus.APPROVED);
    }

    @Override
    public String toString() {
        return "DocumentRequest{" +
                "requestId='" + getRequestId() + '\'' +
                ", residentId='" + getResidentId() + '\'' +
                ", documentType='" + documentType + '\'' +
                ", status=" + getStatus() +
                '}';
    }
}