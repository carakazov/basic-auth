package com.baseauth.server.repository.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.baseauth.server.model.Developer;
import com.baseauth.server.repository.GenericRepository;
import org.springframework.stereotype.Component;

@Component
public class DeveloperRepository implements GenericRepository<Developer> {
    private static final Set<Developer> DEVELOPERS = new HashSet<>();
    private static Integer CURRENT_ID = 0;

    @Override
    public Set<Developer> getAll() {
        return Set.copyOf(DEVELOPERS);
    }

    @Override
    public Developer getById(Integer id) {
        return DEVELOPERS.stream()
            .filter(item -> id.equals(item.getId()))
            .findFirst()
            .orElse(null);
    }

    @Override
    public Developer save(Developer object) {
        CURRENT_ID++;
        object.setId(CURRENT_ID);
        DEVELOPERS.add(object);
        return object;
    }

    @Override
    public void delete(Integer id) {
        Developer developer = getById(id);
        DEVELOPERS.remove(developer);
    }
}
