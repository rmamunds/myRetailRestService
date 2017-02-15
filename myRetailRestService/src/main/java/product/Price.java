package product;


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
		return String.format("Price: value=%s, currencyCode=%s",value.toString(),currencyCode);
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
