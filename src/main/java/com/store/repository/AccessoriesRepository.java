package com.store.repository;

import com.store.entity.Accessories;
import org.springframework.data.repository.CrudRepository;

public interface AccessoriesRepository extends CrudRepository<Accessories, Long> {
}