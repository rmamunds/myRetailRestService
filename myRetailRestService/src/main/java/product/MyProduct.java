package product;

public class MyProduct {
	private final String id;
	private final String name;
	private final PersistedPrice price;
	
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
