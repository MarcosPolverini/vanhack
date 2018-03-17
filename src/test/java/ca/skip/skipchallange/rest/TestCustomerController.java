package ca.skip.skipchallange.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;

import ca.skip.skipchallange.cfg.AbstractRestTest;
import ca.skip.skipchallange.rest.v1.domain.CustomerTO;

public class TestCustomerController extends AbstractRestTest{

	@Test
	public void shouldAuthenticateCustomer() {
		try {
			MOCK.perform(post("/Customer/auth?email=email@email.com&password=123456"))
				.andExpect(status().isOk());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}	
	
	@Test
	public void shoudCreateNewCustomer() {
		try {
			CustomerTO to = new CustomerTO();
			to.address = "address";
			to.email = "emaill@email.com";
			to.name = "Name";
			to.password = "123456";
			String json = json(to);
			MOCK.perform(post("/Customer")
					.content(json)
					.contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().isOk());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
}
