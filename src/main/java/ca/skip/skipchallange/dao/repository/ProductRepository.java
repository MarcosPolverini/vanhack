package ca.skip.skipchallange.dao.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ca.skip.skipchallange.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	@Query("SELECT * FROM product WHERE name like :productName")
	List<Product> findAllByName(@Param("productName") String productName);
	
	
	@Query("SELECT * FROM product WHERE storeId = :storeId")
	List<Product> findByStoreId(@Param("storeId") Long storeId);
}
