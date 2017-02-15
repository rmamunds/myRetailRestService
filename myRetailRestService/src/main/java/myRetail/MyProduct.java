package myRetail;
/**
 * Product for MyRetail.  Named MyProduct vs Product to avoid ambiguity with redsky.Product
 * 
 * @author Robert Amundson
 *
 */
public class MyProduct {
	private String id;
	private String name;
	private Price price;
	
	public MyProduct(){
	}
	
	public MyProduct(String _id, String _name, Price _price){
		id = _id;
		name = _name;
		price = _price;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Price getPrice() {
		return price;
	}
}
