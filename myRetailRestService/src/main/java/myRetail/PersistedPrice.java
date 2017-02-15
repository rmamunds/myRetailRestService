package myRetail;

import org.springframework.data.annotation.Id;

/**
 * Persisted price wraps price to allow the json return to have only a single
 * id.
 * 
 * @author Robert Amundson
 */
public class PersistedPrice {

	@Id
	private String id;

	private Price price;

	public PersistedPrice() {
	}

	public PersistedPrice(String id, Price price) {
		this.id = id;
		this.price = price;
	}

	public PersistedPrice(String id, Double value, String currencyCode) {
		this.id = id;
		this.price = new Price(value, currencyCode);
	}

	public Price getPrice() {
		return price;
	}

	public Double getValue() {
		return price.getValue();
	}

	public String getCurrencyCode() {
		return price.getCurrencyCode();
	}

	@Override
	public String toString() {
		return String.format("PersistedPrice: id=%s, value=%s, currencyCode=%s", id, price.getValue().toString(),
				price.getCurrencyCode());
	}

}
