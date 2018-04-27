package com.store.service;

import com.store.entity.ClothesMaterial;
import com.store.filter.SimpleFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ClothesMaterialService {

    Iterable<ClothesMaterial> findAll();

    Optional<ClothesMaterial> findById(Long id);

    void save(ClothesMaterial clothesMaterial);

    void delete(Long id);

    Page<ClothesMaterial> findAll(SimpleFilter filter,Pageable pageable);

    Page<ClothesMaterial> findAll(Pageable pageable);
}