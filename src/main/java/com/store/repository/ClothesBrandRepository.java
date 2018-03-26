package com.store.repository;

import com.store.entity.ClothesBrand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesBrandRepository extends CrudRepository<ClothesBrand, Long>{
}
