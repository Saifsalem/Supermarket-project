/*Name: saif salem , ID: 1230760 , instructor : Mamoun Nawahda , section: 2 
 * A Grocery class which is a subclass of the stock item class 
 * this class has three attributes , a name of type String , 
 * an expiary date for the grocery of the type Calender , and a weight of the grocery of the 
 * type float , this class has two constructors , setters and getters , an implementation
 * of the calculate tax method inhereated by the super class stock item , 
 * and a to string method
 * 
 */
import java.util.Calendar;

public class Grocery extends StockItem{
	private String name;
	private Calendar expiaryDate;
	private float weight;
	
	// no argument constructor
	
	public Grocery() {
		super();
		this.name=name;
		this.expiaryDate=expiaryDate;
		this.weight=weight;
		
	}
	
	/*a constructor that takes all attributes from this class and the 
	 * super class 
	 */
	
	public Grocery(String name , Calendar expiaryDate , float weight , String brand ,double discount ,double price) {
		super(brand, discount, price);
		this.name=name;
		this.expiaryDate=expiaryDate;
		this.weight=weight;
		
	}
	
	// setters and getters for the attributes 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public Calendar getExpiaryDate() {
		return expiaryDate;
	}
	public void setExpiaryDate(Calendar expiaryDate) {
		this.expiaryDate = expiaryDate;
	}
	

	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	/* the implementation for the calculate tax inhereted by the
	 *  abstract super class which applies a 5.75% tax 
	 *  on the original price of the grocery
	 */
	
	
	@Override
	public double calculateTax() {
		return (getPrice()+(getPrice()*(5.75/100)));
	}
	
	// an override to the to string method
	
	
	@Override
	public String toString() {
		if(discount>0) {
			return name+""+"("+getPrice()+")"+"has a discount of"+(getDiscount()*100)+"%"+
					",expiery date"+expiaryDate.get(Calendar.DAY_OF_MONTH)+"("+weight+")"+"\n,after discount price is"+
					(getPrice()-(getPrice()*getDiscount()))+",after tax included"+(calculateTax())+"\n\n";
		}else {
			return name+""+"("+getPrice()+")"+",expiery date"+expiaryDate.get(Calendar.DAY_OF_MONTH)+"("+weight+")"
					+"\n,after discount price is"+(getPrice()*getDiscount())+",after tax included"
					+(calculateTax())+"\n\n";
		}
		
	}

	

}
