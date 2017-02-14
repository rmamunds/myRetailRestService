package product;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1095215862496280419L;

	public ProductNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductNotFoundException(String message){
		super(message);
	}
}
