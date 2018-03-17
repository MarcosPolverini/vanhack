package ca.skip.skipchallange.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;

import ca.skip.skipchallange.cfg.AbstractRestTest;
import ca.skip.skipchallange.rest.v1.domain.OrderTO;

public class TestOrderController extends AbstractRestTest {
	
	@Test
	public void shouldGetOrderById() {
		try {
			MOCK.perform(get("/Order/1"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void shouldCreateNewOrder() {
		try {
			String json = json(new OrderTO());
			MOCK.perform(post("/Order")
					.content(json)
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
}