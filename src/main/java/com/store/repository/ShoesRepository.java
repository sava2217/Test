package com.store.repository;

import com.store.entity.Shoes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoesRepository extends CrudRepository<Shoes, Long> {
}