package com.store.service;

import com.store.entity.Season;
import com.store.filter.SimpleFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SeasonService {

    List<Season> findAll();

    Optional<Season> findById(Long id);

    void save(Season season);

    void delete(Long id);

    Page<Season> findAll(SimpleFilter filter,Pageable pageable);

    Page<Season> findAll(Pageable pageable);
}