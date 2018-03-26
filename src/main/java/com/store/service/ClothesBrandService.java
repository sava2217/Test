
package com.store.service;

import com.store.entity.ClothesBrand;

import java.util.Optional;

public interface ClothesBrandService  {
    Iterable<ClothesBrand> findAll();
    Optional<ClothesBrand> findOne(Long id);
    ClothesBrand save(ClothesBrand clothesBrand);
    void delete(Long id);
}
