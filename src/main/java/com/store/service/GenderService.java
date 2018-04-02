package com.store.service;

import com.store.entity.Gender;

import java.util.Optional;

public interface GenderService  {
    Iterable<Gender> findAll();
    Optional<Gender> findOne(Long id);
    Gender save(Gender gender);
    void delete(Long id);
}