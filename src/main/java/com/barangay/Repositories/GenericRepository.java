package com.barangay.repositories;

import java.util.List;

public interface GenericRepository<T> {

    void add(T item);

    void remove(T item);

    List<T> getAll();

}