package myRetail;

/**
 * The price object records the actual value and currency of a product.
 * Validation of currency code and value could occur during creation here. ie no
 * Bison dollars or negative values.
 * 
 * @author Robert Amundson
 *
 */
public class Price {

	private Double value;
	private String currencyCode;

	public Price() {
	}

	public Price(Double value, String currencyCode) {
		this.value = value;
		this.currencyCode = currencyCode;
	}

	@Override
	public String toString() {
		return String.format("Price: value=%s, currencyCode=%s", value.toString(), currencyCode);
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}
