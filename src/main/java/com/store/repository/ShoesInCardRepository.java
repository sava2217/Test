package com.store.repository;

import com.store.entity.ShoesInCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoesInCardRepository extends JpaRepository<ShoesInCard, Long> {
}