package com.store.service;

import com.store.entity.ShoesMaterial;

import java.util.Optional;

public interface ShoesMaterialService {
    Iterable<ShoesMaterial> findAll();
    Optional<ShoesMaterial> findOne(Long id);
    ShoesMaterial save(ShoesMaterial shoesMaterial);
    void delete(Long id);
}