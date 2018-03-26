
package com.store.repository;

import com.store.entity.Season;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends CrudRepository<Season, Long>{
}
