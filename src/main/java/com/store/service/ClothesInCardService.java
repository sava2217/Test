package com.store.service;

import com.store.entity.ClothesInCard;

import java.util.List;
import java.util.Optional;

public interface ClothesInCardService {

    List<ClothesInCard> findAll();

    Optional<ClothesInCard> findOne(Long id);

    void save(ClothesInCard clothesInCard);

    void delete(Long id);

}