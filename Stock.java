/*Name : Saif Salem mustafa
 * Student ID:1230760
 * instructor: Dr Mamoun Nawahda   Section 2  / 6
 * 
 * This class has three atributes , constructors to create instances from this class
 * setters and getters for the variables we have , two methods for counting , a toString method,
 * and a method to clone the Arrat list and a method to add an item to the array list;
 */
import java.util.ArrayList;
public class Stock {
	/*Here we define the variables used in this class which is a string for the name ,
	 * A location variables from the type location object which is created in the location class
	 * and an array list of stock items which we will work with later on 
	 */
	private String name;
	private Location location;
	private ArrayList<StockItem> items =new ArrayList<>();
	
	//Here we have a no argument constructor
	
	public Stock() {
		this.name=name;
		this.location=location;
		this.items=new ArrayList<>();
	}
	
	//a constructor which takes a name of type string and creates an array list of stock items
	
	public Stock(String name) {
		this.name=name;
		this.items=new ArrayList<StockItem>();
	}
	/*a constructor which takes a name of type string 
	*and a location of type Location 
	*and creates an object with a name and a location
	*/
	public Stock(String name,Location location) {
		this.name=name;
		this.location=location;
	}
	/*a constructor that takes all atributes 
	 * and creates an object with a name , a location and an 
	 * array list of stock items
	 */
	
	public Stock(String name , Location location , ArrayList<StockItem> item) {
		this.name=name;
		this.location=location;
		this.items=new ArrayList<>();
	}
	
	// getters and setters for the name
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	// getters and setters for the items in the array list of stock items
	
	public ArrayList<StockItem> getItems(){
		return  items;
	}
	
	public void setItems(ArrayList<StockItem>item) {
		this.items=item;
	}
	
	//getters and setters for the location
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location=location;
	}
	
	// a method to add a new item to the array list of the stock item
	
	public void addStockItem(StockItem item) {
		items.add(item);
	}
	/*a method to count the number of electronics in the data 
	 * by iterating through the array list of items
	 * and then checking if the items are of the type electronic 
	 * and incrementing the counter if its an electronic item  
	 */
	
	public int countElectronics() {
		int electronicCounter = 0;
        for (StockItem item : items) {
            if (item instanceof Electronic) {
            	electronicCounter++;
            }
        }
        return electronicCounter;
	}
	/*the same method as the electronic counter but
	 * here the method checks if the item is a grocery
	 * and icreaminting the counter if it is
	 */
	
	public int countGrocery() {
		int groceryCounter = 0;
        for (StockItem item : items) {
            if (item instanceof Grocery) {
            	groceryCounter++;
            }
        }
        return groceryCounter;
	}
	
	// a method to clone(create a copy ) of the array list 
	// by using the (clone) method 

    public ArrayList<StockItem> cloneItems() {
        return (ArrayList<StockItem>) items.clone();
    }
	//a to string method which returns the name , location , and the items array list 
	
	@Override
	public String toString() {
		return "Name: "+getName()+"Location: "
				+getLocation()+"Items: "+getItems();
	}
	
	
	

}
