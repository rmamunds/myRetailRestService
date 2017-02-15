package myRetail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import redSky.RedSkyWrapper;

/**
 * The rest controller for the myRetail service providing values for products
 * PUT and GET. Constructs the MyProduct object from a name extracted from a
 * redsky rest service and a persistedPrice from Mongodb.
 * 
 * @author Robert Amundson
 *
 */
@RestController
public class RetailController {

	private final Logger log = LoggerFactory.getLogger(RetailController.class);

	@Autowired
	private PersistedPriceRepository repository;

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public MyProduct product(@PathVariable("id") String id) throws Exception {
		return contstructFromDataStore(id);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT, headers = { "content-type=application/json" })
	public MyProduct updateProduct(@PathVariable("id") String id, @RequestBody MyProduct product) throws Exception {

		return contstructFromDataStoreWithUpdate(id, product);
	}

	/**
	 * Logic backing the GET method for /products/
	 * 
	 * @param id
	 * @return
	 * @throws ProductNotFoundException
	 *             if redsky throws an error no valid product could be found.
	 * @throws PricingInfoNotFoundException
	 *             if mongodb does not have a persisted value use products PUT
	 *             to set one.
	 */
	private MyProduct contstructFromDataStore(String id) throws ProductNotFoundException, PricingInfoNotFoundException {
		RestTemplate restTemplate = new RestTemplate();
		String productName;
		try {
			RedSkyWrapper rsp = restTemplate.getForObject(String.format(Constants.RED_SKY_REST, id),
					RedSkyWrapper.class);
			productName = rsp.getProductName();
		} catch (RestClientException e) {
			throw new ProductNotFoundException(id);
		}
		PersistedPrice price = repository.findOne(id);

		if (price != null) {
			return new MyProduct(id, productName, price.getPrice());
		} else {
			throw new PricingInfoNotFoundException(id);
		}
	}

	/**
	 * Logic backing the PUT method for /products/
	 * 
	 * @param id
	 * @param product
	 * @return
	 * @throws NumberFormatException
	 *             if the passed in value is not a double number
	 * @throws ProductNotFoundException
	 *             if redsky throws an error no valid product could be found.
	 */
	private MyProduct contstructFromDataStoreWithUpdate(String id, MyProduct product)
			throws NumberFormatException, ProductNotFoundException {
		RestTemplate restTemplate = new RestTemplate();
		String productName;
		log.info("Start contstructFromDataStoreWithUpdate method id: " + id);
		try {
			// Validate that the id matches against a valid name
			RedSkyWrapper rsp = restTemplate.getForObject(String.format(Constants.RED_SKY_REST, id),
					RedSkyWrapper.class);
			productName = rsp.getProductName();
		} catch (RestClientException e) {
			throw new ProductNotFoundException(id);
		}
		Price price = repository.save(new PersistedPrice(id, product.getPrice())).getPrice();
		// This return results in the behavior that a consumer of this service
		// can send an incorrect name in the initial json body and have the
		// value corrected
		return new MyProduct(id, productName, price);
	}

}
