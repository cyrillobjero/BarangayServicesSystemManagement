package com.barangay.repositories;

import com.barangay.interfaces.Searchable;
import com.barangay.models.Resident;

import java.util.ArrayList;
import java.util.List;

public class ResidentRepository
        implements GenericRepository<Resident>,
                   Searchable<Resident> {

    private final List<Resident> residents;

    public ResidentRepository() {
        residents = new ArrayList<>();
    }

    @Override
    public void add(Resident resident) {
        residents.add(resident);
    }

    @Override
    public void remove(Resident resident) {
        residents.remove(resident);
    }

    @Override
    public List<Resident> getAll() {
        return new ArrayList<>(residents);
    }

    public Resident searchById(String id) {

        for (Resident resident : residents) {

            if (resident.getResidentId().equalsIgnoreCase(id)) {
                return resident;
            }
        }

        return null;
    }

    @Override
    public List<Resident> search(String keyword) {
        List<Resident> results = new ArrayList<>();

        for (Resident resident : residents) {
            if (resident.getResidentId().equalsIgnoreCase(keyword)
                    || resident.getFirstName().equalsIgnoreCase(keyword)
                    || resident.getLastName().equalsIgnoreCase(keyword)
                    || resident.getAddress().equalsIgnoreCase(keyword)) {
                results.add(resident);
            }
        }

        return results;
    }
}