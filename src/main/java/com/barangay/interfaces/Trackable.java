package com.barangay.interfaces;

import com.barangay.models.ServiceStatus;

public interface Trackable {

    void updateStatus(ServiceStatus status);

    ServiceStatus getStatus();
}