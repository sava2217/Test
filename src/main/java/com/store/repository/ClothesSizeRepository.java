package com.store.repository;
        import com.store.entity.ClothesSize;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface ClothesSizeRepository extends CrudRepository<ClothesSize, Long>{
}
