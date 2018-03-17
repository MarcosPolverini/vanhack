package ca.skip.skipchallange.dao.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ca.skip.skipchallange.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	@Query("SELECT * FROM customer WHERE email like :email")
	Optional<Customer> findByEmail(@Param("email") String email);
}
