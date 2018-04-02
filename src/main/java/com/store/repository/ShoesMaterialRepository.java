package com.store.repository;

import com.store.entity.ShoesMaterial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoesMaterialRepository extends CrudRepository<ShoesMaterial, Long> {
}