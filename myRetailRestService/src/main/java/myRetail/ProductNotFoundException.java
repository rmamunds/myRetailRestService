package myRetail;
/**
 * An exception representing a fail return from the redsky framework.
 * @author Robert Amundson
 *
 */
public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1095215862496280419L;

	public ProductNotFoundException() {
	}
	
	public ProductNotFoundException(String message){
		super(message);
	}
}
