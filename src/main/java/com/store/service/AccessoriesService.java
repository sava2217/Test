package com.store.service;

import com.store.entity.Accessories;

import java.util.Optional;

public interface AccessoriesService {
    Optional<Accessories> findOne(Long id);

    Iterable<Accessories> findAll();

    void delete(Long id);

    Accessories save(Accessories accessories);
}