package redSky;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private static final Logger log = LoggerFactory.getLogger(Item.class);
	
	@JsonProperty("tcin")
	private long id;
	private long upc;
	private ProductDescription product_description;
	private static final String template = "RedSky item :%d, name: %s upc: %d";
	
	public long getId(){
		return id;
	}
	
	public long getUpc(){
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
		return String.format(template, id, product_description.getTitle(),upc);
	}
}
