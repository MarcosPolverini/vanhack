package ca.skip.skipchallange.dao.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ca.skip.skipchallange.domain.Cousine;

public interface CousineRepository extends CrudRepository<Cousine, Long> {

	@Query("SELECT * FROM cousine WHERE name like :name")
	List<Cousine> findByName(@Param("name") String name);
	
}
