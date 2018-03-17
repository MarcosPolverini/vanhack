package ca.skip.skipchallange.dao.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ca.skip.skipchallange.domain.Store;

public interface StoreRepository extends CrudRepository<Store, Long> {

	@Query("SELECT * FROM store WHERE name like :storeName")
	List<Store> findByName(@Param("storeName") String storeName);
	
	@Query("SELECT * FROM store WHERE cousineId = :cousineId")
	List<Store> findAllByCousinId(@Param("cousineId") Long cousinId);
}
