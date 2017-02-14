package redSky;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Wrapper for encasing outermost json layer from Redsky.
 * @author Robert Amundson
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RedSkyWrapper {
	
	private Product product;
	
	public RedSkyWrapper(){
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String getProductName() {
		return this.getProduct().getItem().getProduct_description().getTitle();
	}

	
	@Override
	public String toString() {
		return product.toString();
	}
	

}
