package com.store.repository;

import com.store.entity.ShoesSize;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoesSizeRepository extends CrudRepository<ShoesSize, Long> {
}