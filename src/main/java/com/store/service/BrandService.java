package com.store.service;

import com.store.entity.Brand;
import com.store.filter.SimpleFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    List<Brand> findAll();

    Optional<Brand> findById(Long id);

    void save(Brand brand);

    void delete(Long id);

    Page<Brand> findAll(SimpleFilter filter,Pageable pageable);

    Page<Brand> findAll(Pageable pageable);
}