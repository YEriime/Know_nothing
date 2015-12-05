//StockManagement.java
import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
    	for(Product value:stock){
    		if(item.getID()!=value.getID())
    			continue;
    		else{
    			System.out.println("该ID已被使用");
    			return;
    		}
    	}
		stock.add(item);
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
    	for(Product value:stock){
    		if(value.getID()==id)
    			value.increaseQuantity(amount);
    	}		
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
    	for(Product value:stock){
    		if(value.getID()==id)
    			return value;
    	}
        return null;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
    	for(Product value:stock){
    		if(value.getID()==id)
    			return value.getQuantity();
    	}
    	return 0;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
    	for(Product value:stock){
    		System.out.println(value.toString());
    	}
    }
    public void printLowProducts(int x){
    	for(Product value:stock){
    		if(value.getQuantity()<x)
        		System.out.println(value.toString());
    	}
    }
    public Product findProductByName(String name){
    	for(Product value:stock){
    		if(value.getName()==name)
    			return value;
    	}
    	return null;
    }
}
