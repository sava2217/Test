package com.store.repository;

import com.store.entity.Clothes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesRepostirory extends CrudRepository<Clothes,Long> {
}