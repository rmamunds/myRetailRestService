package redSky;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the Item object from redsky containing simple data such as product
 * description.
 * 
 * @author Robert Amundson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

	@JsonProperty("tcin")
	private long id;
	private long upc;
	private ProductDescription product_description;
	private static final String template = "RedSky item :%d, name: %s upc: %d";

	public long getId() {
		return id;
	}

	public long getUpc() {
		return upc;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUpc(long upc) {
		this.upc = upc;
	}

	public ProductDescription getProduct_description() {
		return product_description;
	}

	public void setProduct_description(ProductDescription product_description) {
		this.product_description = product_description;
	}

	@Override
	public String toString() {
		return String.format(template, id, product_description.getTitle(), upc);
	}
}
