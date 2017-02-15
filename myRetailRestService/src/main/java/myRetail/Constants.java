package myRetail;

/**
 * Constants for ease of readability.
 * 
 * @author Robert Amundson
 */
public class Constants {

	/**
	 * Target for the redsky rest service. Expects a String.format substitution
	 * for ID.
	 */
	public static String RED_SKY_REST = "http://redsky.target.com/v1/pdp/tcin/%s?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

	public static String PRODUCT_NOT_FOUND_EXCEPTION = "Product not found for id: %s.  Enter a valid product.";
	public static String PRICING_INFO_NOT_FOUND_EXCEPTION = "Pricing info for product not found id: %s.  Update database and try again.";

	public static String PRICING_INFO_VALUE_NOT_A_NUMBER_EXCEPTION = "New price value is not a number as expected.  Check your input data.";
}
