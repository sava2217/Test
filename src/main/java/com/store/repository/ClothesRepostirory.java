package com.store.repository;

import com.store.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesRepostirory extends JpaRepository<Clothes,Long>,JpaSpecificationExecutor<Clothes> {
}