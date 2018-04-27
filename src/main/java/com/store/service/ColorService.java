package com.store.service;

import com.store.entity.Color;
import com.store.filter.SimpleFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ColorService {

    List<Color> findAll();

    Optional<Color> findById(Long id);

    void save(Color color);

    void delete(Long id);

    Page<Color> findAll(SimpleFilter filter,Pageable pageable);

    Page<Color> findAll(Pageable pageable);
}