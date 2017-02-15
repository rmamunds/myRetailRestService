package product;

import org.springframework.data.annotation.Id;

public class PersistedPrice {
	
	@Id
	private String id;
	
	private Double value;
	private String currencyCode;
	
	public PersistedPrice() {
	}
	
	public PersistedPrice(String id, Double value, String currencyCode) {
		this.id = id;
		this.value = value;
		this.currencyCode = currencyCode;
	}
	
	@Override
	public String toString() {
		return String.format("PersistedPrice: id=%s, value=%s, currencyCode=%s",id,value.toString(),currencyCode);
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
