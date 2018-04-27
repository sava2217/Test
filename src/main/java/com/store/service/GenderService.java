package com.store.service;

import com.store.entity.Gender;
import com.store.filter.SimpleFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GenderService {

    List<Gender> findAll();

    Optional<Gender> findById(Long id);

    void save(Gender gender);

    void delete(Long id);

    Page<Gender> findAll(SimpleFilter filter,Pageable pageable);

    Page<Gender> findAll(Pageable pageable);
}