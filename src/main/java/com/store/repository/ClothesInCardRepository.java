package com.store.repository;

import com.store.entity.ClothesInCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesInCardRepository extends JpaRepository<ClothesInCard, Long> {
}