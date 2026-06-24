package com.barangay.services;

import com.barangay.models.Resident;
import com.barangay.repositories.ResidentRepository;

import java.util.List;

public class ResidentService {

    private final ResidentRepository repository;

    public ResidentService(
            ResidentRepository repository) {

        this.repository = repository;
    }

    public void registerResident(
            Resident resident) {

        repository.add(resident);
    }

    public Resident findResident(
            String residentId) {

        return repository.searchById(residentId);
    }

    public List<Resident> getAllResidents() {

        return repository.getAll();
    }
}
