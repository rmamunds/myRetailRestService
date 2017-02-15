package redSky;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Product object from redsky contains an item where the current information of
 * interest exists.
 * 
 * @author Robert Amundson
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

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
