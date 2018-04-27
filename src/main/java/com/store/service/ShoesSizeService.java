package com.store.service;

import com.store.entity.ShoesSize;
import com.store.filter.SimpleFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ShoesSizeService {

    List<ShoesSize> findAll();

    Optional<ShoesSize> findById(Long id);

    void save(ShoesSize shoesSize);

    void delete(Long id);

    Page<ShoesSize> findAll(SimpleFilter filter,Pageable pageable);

    Page<ShoesSize> findAll(Pageable pageable);
}