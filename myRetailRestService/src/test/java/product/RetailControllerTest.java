package product;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import myRetail.MyProduct;
import myRetail.PersistedPrice;
import myRetail.PersistedPriceRepository;
import myRetail.RetailController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class RetailControllerTest {

	@Autowired
	private PersistedPriceRepository repository;

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	private static PersistedPrice LEBOWSKI_PRICE =new PersistedPrice("13860428", 29.99, "USD");
	private static PersistedPrice LEBOWSKI_NEW_PRICE =new PersistedPrice("13860428", 19.99, "USD");

	@Configuration
	@EnableAutoConfiguration
	public static class Config {
		@Bean
		public RetailController RetailController() {
			return new RetailController();
		}
	}

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	/**
	 * Basic get test.  Does get successfully access both the redsky and local mongodb<PersistedPrice> resources
	 * @throws Exception
	 */
	@Test
	public void testGetProducts() throws Exception {
		repository.deleteAll();
		//Initial test data
		repository.save(LEBOWSKI_PRICE);
		mockMvc.perform(get("/products/13860428").accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id", is("13860428")))
		.andExpect(jsonPath("$.name", is("The Big Lebowski (Blu-ray)")))
		.andExpect(jsonPath("$.price.value", is(LEBOWSKI_PRICE.getValue())))
		.andExpect(jsonPath("$.price.currencyCode", is(LEBOWSKI_PRICE.getCurrencyCode())))
		;
	}
	/**
	 * Check that a put successfully completes and returns the updated object.
	 * @throws Exception
	 */
	@Test
	public void testPutProduct() throws Exception {
		repository.deleteAll();
		//Initial test data
		repository.save(LEBOWSKI_PRICE);
		String json = new ObjectMapper().writeValueAsString(new MyProduct("13860428","Passed name has no effect", LEBOWSKI_NEW_PRICE.getPrice()));
		mockMvc.perform(put("/products/13860428").content(json).contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id", is("13860428")))
		.andExpect(jsonPath("$.name", is("The Big Lebowski (Blu-ray)")))
		.andExpect(jsonPath("$.price.value", is(LEBOWSKI_NEW_PRICE.getValue())))
		.andExpect(jsonPath("$.price.currencyCode", is(LEBOWSKI_NEW_PRICE.getCurrencyCode())))
		;
	}

	/**
	 * Test that a subsequent get still has the persisted information.
	 * @throws Exception
	 */
	@Test
	public void testPutProductPersistence() throws Exception {
		repository.deleteAll();
		//Initial test data
		repository.save(LEBOWSKI_PRICE);
		String json = new ObjectMapper().writeValueAsString(new MyProduct("13860428","Passed name has no effect", LEBOWSKI_NEW_PRICE.getPrice()));
		mockMvc.perform(put("/products/13860428").content(json).contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id", is("13860428")))
		.andExpect(jsonPath("$.name", is("The Big Lebowski (Blu-ray)")))
		.andExpect(jsonPath("$.price.value", is(LEBOWSKI_NEW_PRICE.getValue())))
		.andExpect(jsonPath("$.price.currencyCode", is(LEBOWSKI_NEW_PRICE.getCurrencyCode())))
		;

		mockMvc.perform(get("/products/13860428").accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id", is("13860428")))
		.andExpect(jsonPath("$.name", is("The Big Lebowski (Blu-ray)")))
		.andExpect(jsonPath("$.price.value", is(LEBOWSKI_NEW_PRICE.getValue())))
		.andExpect(jsonPath("$.price.currencyCode", is(LEBOWSKI_NEW_PRICE.getCurrencyCode())))
		;
	}
}