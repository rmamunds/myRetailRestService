package myRetail;

/**
 * An exception representing a product with no persisted price.
 * 
 * @author Robert Amundson
 *
 */
public class PricingInfoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4264316704071924965L;

	public PricingInfoNotFoundException() {
	}

	public PricingInfoNotFoundException(String message) {
		super(message);
	}
}
