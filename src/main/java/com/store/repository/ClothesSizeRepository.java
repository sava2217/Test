package com.store.repository;
import com.store.entity.ClothesSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesSizeRepository extends JpaRepository<ClothesSize, Long>,JpaSpecificationExecutor<ClothesSize> {
}