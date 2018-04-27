package com.store.service;

import com.store.entity.Clothes;
import com.store.filter.ClothesFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClothesService {

    Iterable<Clothes> findAll();

    Page<Clothes> findAll(Pageable pageable);

    Page<Clothes> findAll(Pageable pageable,ClothesFilter filter);

    Optional<Clothes> findOne(Long id);

    void save(Clothes clothes);

    void delete(Long id);

}