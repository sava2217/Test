package com.store.service;

import com.store.entity.Color;

import java.util.Optional;

public interface ColorService  {
    Iterable<Color> findAll();
    Optional<Color> findOne(Long id);
    Color save(Color color);
    void delete(Long id);
}
