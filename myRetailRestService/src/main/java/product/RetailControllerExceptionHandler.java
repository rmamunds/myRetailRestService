package product;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RetailControllerExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = { ProductNotFoundException.class})
	public ResponseEntity<Object> productNotFound(ProductNotFoundException e, WebRequest req){
		return handleExceptionInternal(e,String.format(Constants.PRODUCT_NOT_FOUND_EXCEPTION,e.getMessage()),new HttpHeaders(),HttpStatus.CONFLICT,req);
	}
	@ExceptionHandler(value = { PricingInfoNotFoundException.class})
	public ResponseEntity<Object> pricingInfoNotFound(PricingInfoNotFoundException e, WebRequest req){
		return handleExceptionInternal(e,String.format(Constants.PRICING_INFO_NOT_FOUND_EXCEPTION,e.getMessage()),new HttpHeaders(),HttpStatus.CONFLICT,req);
	}
	
	@ExceptionHandler(value = { NumberFormatException.class})
	public ResponseEntity<Object> pricingInfoValueNotANumber(NumberFormatException e, WebRequest req){
		return handleExceptionInternal(e,new StringBuilder(Constants.PRICING_INFO_VALUE_NOT_A_NUMBER_EXCEPTION).append(e.getMessage()),new HttpHeaders(),HttpStatus.CONFLICT,req);
	}
}
