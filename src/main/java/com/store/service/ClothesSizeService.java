package com.store.service;

import com.store.entity.ClothesSize;
import com.store.filter.SimpleFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClothesSizeService {

    Iterable<ClothesSize> findAll();

    Optional<ClothesSize> findById(Long id);

    void save(ClothesSize clothesSize);

    void delete(Long id);

    Page<ClothesSize> findAll(SimpleFilter filter,Pageable pageable);

    Page<ClothesSize> findAll(Pageable pageable);
}