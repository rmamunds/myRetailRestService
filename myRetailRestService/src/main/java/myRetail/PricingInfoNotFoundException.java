package myRetail;

public class PricingInfoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4264316704071924965L;

	public PricingInfoNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public PricingInfoNotFoundException(String message){
		super(message);
	}
}
