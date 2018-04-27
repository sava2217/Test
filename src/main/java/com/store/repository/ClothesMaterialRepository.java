
package com.store.repository;

import com.store.entity.ClothesMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesMaterialRepository extends JpaRepository<ClothesMaterial, Long>,JpaSpecificationExecutor<ClothesMaterial> {
}