package com.store.service;

import com.store.entity.Shoes;

import java.util.Optional;

public interface ShoesService {
    Iterable<Shoes> findAll();
    Optional<Shoes> findOne(Long id);
    Shoes save(Shoes shoes);
    void delete(Long id);
}