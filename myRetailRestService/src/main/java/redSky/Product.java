package redSky;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private static final Logger log = LoggerFactory.getLogger(Product.class);

	private Item item;

	public void setItem(Item _item) {
		item = _item;
	}
	
	public Item getItem() {
		return item;
	}

	@Override
	public String toString() {
		return item.toString();
	}
}
