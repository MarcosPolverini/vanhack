package ca.skip.skipchallange.rest.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.skip.skipchallange.dao.repository.CustomerRepository;
import ca.skip.skipchallange.domain.Customer;
import ca.skip.skipchallange.exception.BadCredentialsException;
import ca.skip.skipchallange.facade.LoginBean;
import ca.skip.skipchallange.rest.v1.domain.CustomerTO;

@Component
@RestController
@RequestMapping("Customer")
public final class CustomerController {

	@Autowired
	private LoginBean bean;

	@Autowired
	private CustomerRepository repository;

	@RequestMapping(path = "auth", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public void login(String email, String password) throws BadCredentialsException {
		bean.Login(email, password);
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public void create(@RequestBody CustomerTO customer) {
		repository.save(new Customer(customer.id, customer.email, customer.name, customer.address, customer.creation, customer.password));
	}
}