/*Name: saif salem , ID: 1230760 , Instructor : Mamoun Nawahda , section: 2
 *The electronic class which is a subclass of the super class stock item ,
 *this class has three attributes : version of the electronic of the type string ,
 *type of the electronic of the type string and power of the electrionic 
 *of the type double , this class has two constructors , setters and getters , an
 *implementation of the calculate tax which was inhereted by the abstract superclass 
 * stock item and a to string method
 */
public class Electronic extends StockItem {
	private String version;
	private String type;
	private double power;
	
	//a no argument constructor
	
	public Electronic() {
		this.version=version;
		this.type = type;
		this.power=power;
	}
	
	// a constructor that takes all attributes of this class and the super class
	
	public Electronic(String version , String type , double power,  String brand ,double discount ,double price) {
		super(brand, discount, price);
		this.version=version;
		this.type=type;
		this.power=power;
	}
	
	//setters and getters
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version=version;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type=type;
	}
	
	
	public double getPower() {
		return power;
	}
	public void setPower(double power) {
		this.power=power;
	}
	
	/* an implementation of the inhereted calculate tax method
	 * by the abstract super class which applies a 16.5%
	 * tax on the original price of the electronic
	 */
	
	@Override
	public double calculateTax() {
		return (getPrice()+(getPrice()*(16.5/100)));
	}
	
	// an override to the to string method
	
	@Override
	public String toString() {
		return getBrand()+"("+getPrice()+")"+"with a discount of "+(getDiscount()*100)+"%"
				+"("+getType()+")"+getPower()+"."+"\nAfter discount price is "+(getPrice()-(getPrice()*getDiscount()))+
				", after tax included "+"("+(calculateTax())+")."+"\n\n";
	}

	

}
