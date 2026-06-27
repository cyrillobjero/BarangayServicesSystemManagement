package com.barangay.repositories;

import com.barangay.interfaces.Searchable;
import com.barangay.requests.BarangayService;

import java.util.ArrayList;
import java.util.List;

public class RequestRepository
        implements GenericRepository<BarangayService>,
                   Searchable<BarangayService> {

    private final List<BarangayService> requests;

    public RequestRepository() {
        requests = new ArrayList<>();
    }

    @Override
    public void add(BarangayService request) {
        requests.add(request);
    }

    @Override
    public void remove(BarangayService request) {
        requests.remove(request);
    }

    @Override
    public List<BarangayService> getAll() {
        return new ArrayList<>(requests);
    }

    public BarangayService searchById(String id) {

        for (BarangayService request : requests) {

            if (request.getRequestId()
                    .equalsIgnoreCase(id)) {

                return request;
            }
        }

        return null;
    }

    @Override
    public List<BarangayService> search(String keyword) {
        List<BarangayService> results = new ArrayList<>();

        for (BarangayService request : requests) {
            if (request.getRequestId().equalsIgnoreCase(keyword)
                    || request.getResidentId().equalsIgnoreCase(keyword)) {
                results.add(request);
            }
        }

        return results;
    }
}