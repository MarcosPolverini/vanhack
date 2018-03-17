package ca.skip.skipchallange.dao.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ca.skip.skipchallange.domain.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

	@Query("SELECT * FROM item WHERE orderId = :orderId")
	List<Item> findAllByOrderId(@Param("orderId") Long orderId);
}
