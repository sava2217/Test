
package com.store.service;

import com.store.entity.ClothesMaterial;

import java.util.Optional;

public interface ClothesMaterialService  {
    Iterable<ClothesMaterial> findAll();
    Optional<ClothesMaterial> findOne(Long id);
    ClothesMaterial save(ClothesMaterial clothesMaterial);
    void delete(Long id);
}