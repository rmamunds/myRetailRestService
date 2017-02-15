package product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import product.MyProduct;

public class MyProductTest {
    @Test public void testSimpleProduct() {
    	String id = "1000";
    	String name = "Simple Item";
        MyProduct simpleItem = new MyProduct(id,name,new Price(Double.valueOf(100), "USD"));
        assertTrue("Get name always returns name", simpleItem.getName().equals(name));
        assertTrue("Get id always returns id", simpleItem.getId()==id);
        assertEquals("Get price always returns price",Double.valueOf(100), simpleItem.getPrice().getValue());
    }
}
