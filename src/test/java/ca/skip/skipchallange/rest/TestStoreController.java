package ca.skip.skipchallange.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;

import ca.skip.skipchallange.cfg.AbstractRestTest;

public class TestStoreController extends AbstractRestTest {

	@Test
	public void shoulGetAllStores() {
		try {
			MOCK.perform(get("/Store"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void shouldGetStoreById() {
		try {
			MOCK.perform(get("/Store/1"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void shouldGetAllProductsFromStore() {
		try {
			MOCK.perform(get("/Store/1/products"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void shouldGetStoresByCousinId() {
		try {
			MOCK.perform(get("/Store/search/A"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));;
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
}