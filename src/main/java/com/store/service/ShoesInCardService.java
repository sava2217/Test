package com.store.service;

import com.store.entity.ShoesInCard;

import java.util.List;
import java.util.Optional;

public interface ShoesInCardService {

    List<ShoesInCard> findAll();

    Optional<ShoesInCard> findOne(Long id);

    void save(ShoesInCard shoesInCard);

    void delete(Long id);

}