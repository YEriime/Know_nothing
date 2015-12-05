//StockDemo.java
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 */
import java.util.*;
public class StockDemo
{
    // The stock manager.
    private StockManager manager;

    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo()
    {
        manager = new StockManager();
        manager.addProduct(new Product(132, "Clock Radio"));
        manager.addProduct(new Product(37,  "Mobile Phone"));
        manager.addProduct(new Product(23,  "Microwave Oven"));
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    public void demo()
    {
        // Show details of all of the products.
        manager.printProductDetails();
        // Take delivery of 5 items of one of the products.
        manager.delivery(132, 5);
        manager.printProductDetails();
    }
    
    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void showDetails(int id)
    {
        Product product = getProduct(id);
        if(product != null) {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id)
    {
        Product product = getProduct(id);
        
        if(product != null) {
            showDetails(id);
            product.sellOne();
            showDetails(id);
        }
    }
    
    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     * @param id The ID of the product.
     * @return The Product, or null if no matching one is found.
     */
    public Product getProduct(int id)
    {
        Product product = manager.findProduct(id);
        if(product == null) {
            System.out.println("Product with ID: " + id +
                               " is not recognised.");
        }
        return product;
    }

    /**
     * @return The stock manager.
     */
    public StockManager getManager()
    {
        return manager;
    }
    public static void main(String[] args){
    	int t;
        Scanner input=new Scanner(System.in);
        StockDemo test=new StockDemo();
        System.out.println("开始测试！");
        test.demo();
        System.out.print("请输入要查看商品货号：");
        do{
            int num=input.nextInt();
            t=num;
            if(t==0) break;
        	test.showDetails(num);
            System.out.print("若想进行其他操作请输入0,请输入货号：");
        }while(t!=0);
        System.out.print("请输入要卖出商品的货号：");
        do{
            int num=input.nextInt();
            t=num;
            if(t==0) break;
            test.sellProduct(t);
            System.out.print("若想进行其他操作请输入0,请输入货号：");
        }while(t!=0);
        test.getProduct(132);
        input.close();
        System.out.print("测试成功！");
    }
}
