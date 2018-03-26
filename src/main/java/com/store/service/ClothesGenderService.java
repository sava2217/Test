
package com.store.service;

import com.store.entity.ClothesGender;

import java.util.Optional;

public interface ClothesGenderService  {
    Iterable<ClothesGender> findAll();
    Optional<ClothesGender> findOne(Long id);
    ClothesGender save(ClothesGender clothesGender);
    void delete(Long id);
}
