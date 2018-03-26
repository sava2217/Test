
package com.store.repository;

        import com.store.entity.ClothesGender;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface ClothesGenderRepository extends CrudRepository<ClothesGender, Long>{
}
