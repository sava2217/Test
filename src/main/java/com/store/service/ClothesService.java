package com.store.service;

import com.store.entity.Clothes;

import java.util.Optional;

public interface ClothesService   {
    Iterable<Clothes> findAll();
    Optional<Clothes> findOne(Long id);
    Clothes save(Clothes clothes);
    void delete(Long id);
}