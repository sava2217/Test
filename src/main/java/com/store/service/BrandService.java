package com.store.service;

        import com.store.entity.Brand;

        import java.util.Optional;

public interface BrandService  {
    Iterable<Brand> findAll();
    Optional<Brand> findOne(Long id);
    Brand save(Brand brand);
    void delete(Long id);
}
