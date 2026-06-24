package com.barangay.services;

import com.barangay.requests.BarangayService;
import com.barangay.repositories.RequestRepository;

import java.util.List;

public class RequestService {

    private final RequestRepository repository;

    public RequestService(
            RequestRepository repository) {

        this.repository = repository;
    }

    public void submitRequest(
            BarangayService request) {

        repository.add(request);
    }

    public BarangayService findRequest(
            String requestId) {

        return repository.searchById(requestId);
    }

    public List<BarangayService> getAllRequests() {

        return repository.getAll();
    }
}
