package com.store.service;

import com.store.entity.Season;

import java.util.Optional;

public interface SeasonService  {
    Iterable<Season> findAll();
    Optional<Season> findOne(Long id);
    Season save(Season season);
    void delete(Long id);
}