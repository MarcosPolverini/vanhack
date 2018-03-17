package ca.skip.skipchallange.dao;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import ca.skip.skipchallange.cfg.AbstractTest;
import ca.skip.skipchallange.dao.repository.CustomerRepository;
import ca.skip.skipchallange.domain.Customer;

public class TestCustomerRepository extends AbstractTest{

	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private JdbcTemplate template;
	
	@Before
	public void cleanBase() {
		template.execute("DELETE FROM customer  WHERE email = 'email@email.com'");
	}
	
	@Test
	public void positiveManager() {
		shouldBeInsert();
		shoulGetByEmail();
	}
	
	private void shouldBeInsert() {
		Customer customer = new Customer();
		customer.setAddress("New Address for JUNIT");
		customer.setEmail("email@email.com");
		customer.setName("Customer name");
		customer.setPassword("New hard password");
		repository.save(customer);
	}
	
	private  void shoulGetByEmail() {
		Optional<Customer> customer = repository.findByEmail("email@email.com");
		Assert.assertTrue(customer.isPresent());
		Assert.assertNotNull(customer.get());
	}
}
