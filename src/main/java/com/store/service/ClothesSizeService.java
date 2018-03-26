
package com.store.service;

        import com.store.entity.ClothesSize;

        import java.util.Optional;

public interface ClothesSizeService  {
    Iterable<ClothesSize> findAll();
    Optional<ClothesSize> findOne(Long id);
    ClothesSize save(ClothesSize clothesSize);
    void delete(Long id);
}
