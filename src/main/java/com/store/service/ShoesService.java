package com.store.service;

import com.store.entity.Shoes;
import com.store.filter.ShoesFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ShoesService {

    Iterable<Shoes> findAll();

    Page<Shoes> findAll(Pageable pageable);

    Page<Shoes> findAll(Pageable pageable,ShoesFilter filter);

    Optional<Shoes> findOne(Long id);

    void save(Shoes shoes);

    void delete(Long id);

}