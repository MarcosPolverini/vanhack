package ca.skip.skipchallange.cfg;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class AbstractRestTest extends AbstractTest{

	// Create one for all tests
	protected static MockMvc MOCK;

	private HttpMessageConverter mappingMock;

	@Autowired
	private WebApplicationContext webContext;

	@Before
	public void setUp() {
		if (MOCK == null)
			MOCK = MockMvcBuilders.webAppContextSetup(webContext).build();
	}

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {
		mappingMock = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().orElse(null);
		Assert.assertNotNull("the JSON message converter must not be null", mappingMock);
	}

	protected String json(Object o) throws IOException {
		MockHttpOutputMessage mockMessage = new MockHttpOutputMessage();
		mappingMock.write(o, MediaType.APPLICATION_JSON_UTF8, mockMessage);
		return mockMessage.getBodyAsString();
	}
}
