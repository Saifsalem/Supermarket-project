/*Name: saif salem , Id: 1230760 , instructor: Mamoun nawahda , section 2
 * 
 * The StockItem class which is abstract and will be used as a base class
 * this class implements the comparable interface 
 * in this class we have three atributes , two constructors , one abstract method 
 * and three methods that are overRidden 
 */
public abstract class StockItem<Item> implements Comparable<Item>{
	protected String brand;
	protected double discount;
	protected double price;
	
	// a no argument constructor 
	public StockItem() {
		this.brand=brand;
		this.discount=discount;
		this.price=price;
	}
	
	// a costructor that takes all atributes
	
	public StockItem(String brand, double discount, double price) {
		this.brand=brand;
		this.discount=discount;
		this.price=price;
	}
	
	// setters and getters 
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand=brand;
	}
	
	
	
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount=discount;
	}
	
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	
	// an abstract method to calculate the tax which will be implemented in the 
	// subclasses of this class
	
	public abstract  double calculateTax() ;
	
	
	//the to string method
	
	@Override
	public String toString() {
		if(discount>0) {
			return getBrand()+"("+getPrice()+")"+"has a discount of"+(discount*100)+"%";
		}else
			return getBrand()+"("+getPrice()+")";
		       
	}
	
	/*an override to the compareTo method that compares two objects based on
	 * Price , if the first object price is higher than the second then the method will return 
	 * 1 , if the prices of the two objects are equal then the method will return 0
	 * if the second objects price is higher than the first then the method will return -1
	 */

	@Override
	public int compareTo(Item item) {
		if(equals(item)) {
			if(this.price > ((StockItem) item).getPrice()) {
				return 1;
			}
			else if (this.price < ((StockItem) item).getPrice()) {
				return -1;
			}
			else 
				return 0;
		}
		return (Integer) null;
		
	}
	
	/*an override to the equals method that checks if the objects we want to 
	 * compare to each other are both stock items and has the same brand 
	 * and the same amount of discount.
	 */
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof StockItem) {
			if(this.brand==((StockItem) obj).brand &&this.discount==((StockItem) obj).discount ) 
				return super.equals(obj);	
		}
		return false;
	}
	
	

}
