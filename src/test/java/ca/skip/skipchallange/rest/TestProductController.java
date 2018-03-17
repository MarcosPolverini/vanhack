package ca.skip.skipchallange.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;

import ca.skip.skipchallange.cfg.AbstractRestTest;

public class TestProductController extends AbstractRestTest {

	@Test
	public void shouldGetAllProducts() {
		try {
			MOCK.perform(get("/Product"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));;
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void shouldGetProductByName() {
		try {
			MOCK.perform(get("/Product/search/a"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void shouldGetProductById() {
		try {
			MOCK.perform(get("/Product/13"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));;
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
}