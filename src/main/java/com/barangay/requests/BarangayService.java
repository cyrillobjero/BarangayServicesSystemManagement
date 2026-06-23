
package com.barangay.requests;

import com.barangay.interfaces.Trackable;
import com.barangay.models.ServiceStatus;

public abstract class BarangayService implements Trackable {

    private String requestId;
    private String residentId;
    private ServiceStatus status;

    public BarangayService(String requestId, String residentId) {
        this.requestId = requestId;
        this.residentId = residentId;
        this.status = ServiceStatus.PENDING;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getResidentId() {
        return residentId;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    @Override
    public void updateStatus(ServiceStatus status) {
        this.status = status;
    }

    public abstract void processRequest();

}
