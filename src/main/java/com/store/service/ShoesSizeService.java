package com.store.service;


import com.store.entity.ShoesSize;

import java.util.Optional;

public interface ShoesSizeService {
    Iterable<ShoesSize> findAll();
    Optional<ShoesSize> findOne(Long id);
    ShoesSize save(ShoesSize shoesSize);
    void delete(Long id);
}