package product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import redSky.RedSkyWrapper;

@RestController  
public class RetailController {
	
	private final Logger log = LoggerFactory.getLogger(RetailController.class);
	
	@Autowired
	private PersistedPriceRepository repository;

	@RequestMapping(value ="/products/{id}", method = RequestMethod.GET) 
	public MyProduct product(@PathVariable("id") String id) throws Exception { 
		return contstructFromDataStore(id);
	}
	@RequestMapping(value ="/products/{id}", method = RequestMethod.PUT)
	public MyProduct updateProduct(@PathVariable("id") String id, @RequestParam(value="value", defaultValue="1.00") String value, @RequestParam(value="currencyCode", defaultValue="USD") String currencyCode) throws Exception { 
		log.info("Got to put method Vals are id: " +id + " Value: " + value+ " CurrencyCode " + currencyCode);
		return contstructFromDataStoreWithUpdate(id,value,currencyCode);
	}
	
	
	private MyProduct contstructFromDataStore(String id) throws ProductNotFoundException,PricingInfoNotFoundException{
        RestTemplate restTemplate = new RestTemplate();
        String productName;
        try {
            RedSkyWrapper rsp = restTemplate.getForObject(String.format(Constants.RED_SKY_REST, id), RedSkyWrapper.class);
            productName = rsp.getProductName();
		} catch (RestClientException e) {
			throw new ProductNotFoundException(id);
		}
        PersistedPrice price = repository.findOne(id);
        if(price!=null){
			return new MyProduct(id,productName,price);
		}else{
			throw new PricingInfoNotFoundException(id);
		}
	}
	
	private MyProduct contstructFromDataStoreWithUpdate(String id, String value, String currencyCode) throws NumberFormatException, ProductNotFoundException,PricingInfoNotFoundException{
        RestTemplate restTemplate = new RestTemplate();
        String productName;
		log.info("Got to updatePersistedPrice method Vals are id: " +id + " Value: " + value+ " CurrencyCode " + currencyCode);
        try {
            RedSkyWrapper rsp = restTemplate.getForObject(String.format(Constants.RED_SKY_REST, id), RedSkyWrapper.class);
            productName = rsp.getProductName();
		} catch (RestClientException e) {
			throw new ProductNotFoundException(id);
		}
        PersistedPrice price = updatePersistedPrice(id,value,currencyCode);
        return new MyProduct(id,productName,price);
	}
	
	private PersistedPrice updatePersistedPrice(String id,String value,String currencyCode){
		log.info("Got to updatePersistedPrice method Vals are id: " +id + " Value: " + value+ " CurrencyCode " + currencyCode);
		return repository.save(new PersistedPrice(id, Double.valueOf(value), currencyCode));
	}
	

}
