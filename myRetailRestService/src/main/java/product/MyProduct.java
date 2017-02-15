package product;

public class MyProduct {
	private String id;
	private String name;
	private PersistedPrice price;
	
	public MyProduct(){
	}
	
	public MyProduct(String _id, String _name, PersistedPrice _price){
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

	public PersistedPrice getPrice() {
		return price;
	}
}
