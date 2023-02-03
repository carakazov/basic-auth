package com.baseauth.server.repository;

import java.util.List;
import java.util.Set;

public interface GenericRepository<T> {
    Set<T> getAll();
    T getById(Integer id);
    T save(T object);
    void delete(Integer id);
}
