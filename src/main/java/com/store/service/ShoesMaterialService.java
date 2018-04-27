package com.store.service;

import com.store.entity.ShoesMaterial;
import com.store.filter.SimpleFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ShoesMaterialService {

    List<ShoesMaterial> findAll();

    Optional<ShoesMaterial> findById(Long id);

    void save(ShoesMaterial shoesMaterial);

    void delete(Long id);

    Page<ShoesMaterial> findAll(SimpleFilter filter,Pageable pageable);

    Page<ShoesMaterial> findAll(Pageable pageable);
}