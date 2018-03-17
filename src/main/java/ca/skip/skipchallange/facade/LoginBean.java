package ca.skip.skipchallange.facade;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.skip.skipchallange.dao.repository.CustomerRepository;
import ca.skip.skipchallange.domain.Customer;
import ca.skip.skipchallange.exception.BadCredentialsException;

@Component
public class LoginBean {

	@Autowired
	private CustomerRepository repository;

	public void Login(String email, String password) throws BadCredentialsException {
		Optional<Customer> customer = repository.findByEmail(email);
		Customer usr = customer.orElseThrow(BadCredentialsException::new);
		usr.validatePassword(password);
	}

}
