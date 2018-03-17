package ca.skip.skipchallange.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;

import ca.skip.skipchallange.cfg.AbstractRestTest;

public class TestCousineController extends AbstractRestTest {

	@Test
	public void shouldGetAllCousines() {
		try {
			MOCK.perform(get("/Cousine")).andExpect(status().isOk());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void shouldGetAllWithContainsText() {
		try {
			MOCK.perform(get("/Cousine/search/A"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void shouldGetStoresByCousinId() {
		try {
			MOCK.perform(get("/Cousine/3/stores"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));;
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
}