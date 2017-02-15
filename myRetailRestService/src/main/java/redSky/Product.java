package redSky;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
