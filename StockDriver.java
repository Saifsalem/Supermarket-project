/*Name: saif salem , ID: 1230760 , instructor : mamoun nawahda , section 2
 * this is the test (driver ) class for all the classes created erlier , 
 * this class provides a menu of options the user could choose from where every 
 * option has its own method and will be explained explicitly beforehand 
 */

import java.io.*;                // bunch of imports to deal with files, IO , Scanner , Array List
import java.text.*;
import java.util.*;
public class StockDriver {
	
	static Scanner input = new Scanner(System.in);        // Scanner to read from the user  
	
	//creating a stock object from the stock class 
	private static Stock stock;           
	
	// defining the simple date format to turn the date into a string 
    static SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
    
    //the main method
	public static void main(String[] args) {
		
		/*creating a location object an assigning values to it 
		 * and assigning values to the stock object of a name and a location object
		 * (i created a constructor that takes a name and a location object in the 
		 *    stock class)
		 */
		Location location = new Location("Lacasa Mall","ALrehan","Ramallah");
		 stock =new Stock("Al-Mashhadawi", location);
		 /*calling the read from file method to load the data 
		  * needed from the file 
		  */
		readFromFile("Data.txt");   
		
		// a do while loop to keep printing the menu of options until the user exits
		
		int option =0;
		do {
			System.out.println("{_______Al-Mashhadawi_______}");
			System.out.println("Menu: ");
			System.out.println("1. Print all items sorted by brand");
			System.out.println("2. Print all items sorted by price");
			System.out.println("3. Print items with a discounts");
			System.out.println("4. Print discounted electronics with details");
			System.out.println("5. print all expierd items");
			System.out.println("6. Add new Grocery or Electronic item");
			System.out.println("7. Make a new copy of all Items in Stock");
			System.out.println("8. Exit");
			System.out.print("Enter the option you want:");
			option =input.nextInt();       // a scanner to read the users choice and a scanner 
			input.nextLine();              // to consume a line after reading the users choice 
			
			switch(option){                // switch case statement 
				case 1:
					sortByBrand();             // calling the methods that sort the items based on brand
					break;
				case 2:
					sortByPrice();             // calling the methods that sort the items based on price
					break;
				case 3:
					printItemsWithAdiscount();     // calling the method that finds the items with a discount
					break;                         // more than a percentage that the user decides
				case 4:
					discountedElectronicsDetails();     // calling the method that print all discounted electronics
					break;
				case 5:
					printExpierdGroceries();        //calling the method that prints all expiered groceries
					break;
				case 6:
					addNewItem();                // calling the method to add a new file to the item
					break;
				case 7:
					cloneStockList();         // calling the method to clone the array list of items
					break;
				case 8:
					System.out.println("Exiting Program... \nHave a great day!");   // exiting message
					break;
				default:
					//message for invalid input from the user
					System.out.println("Invalid choice! Please enter a number within the options");   
					
			
				
			}
		}while(option !=8);          // end of the do-while loop

	}
	
	/* read from file method that takes the file name and uses scanner to read 
	 * inside the file , the scanner will keep reading as long as the file 
	 * has lines , each line is an array of data and the "," seperates each
	 * index of the array from one another , and each index represents a 
	 * value that represents the items in the stock
	 */
	
	public static void readFromFile(String fileName) {
		try (Scanner scanner  = new Scanner(new FileReader(fileName))){
			while((scanner.hasNextLine())) {
				String line = scanner.nextLine();
				String[] data = line.split(",");          
				if(data[0].equalsIgnoreCase("Grocery")) {
					String name =data[1];
					String brand = data[2];
					double discount = Double.parseDouble(data[3])/100;   // casting to double 
					double price = Double.parseDouble(data[4]);
					Calendar expiaryDate = Calendar.getInstance();      // to read a calender value
					expiaryDate.setTime(dateFormat.parse(data[5]));     // casting a date into a string
					float weight = Float.parseFloat(data[6]);           // casting to float
					
					// adding item to the array list of stock items
					stock.addStockItem(new Grocery(name,expiaryDate,weight,brand,discount,price));
					
					// same as before but for electronics
				}else if(data[0].equalsIgnoreCase("Electronics")) {
					String version = data[1];
					String brand =data[2];
					double discount = Double.parseDouble(data[3])/100;  // casting to double 
					double price = Double.parseDouble(data[4]);   // casting to double
					String type = data[5];
					double power = Double.parseDouble(data[6]);   // castong to double 
					
					// adding the item to the array list of stock items 
					stock.addStockItem(new Electronic(version, type,power,brand, discount,price)); 
				}
			}	
			// a catch phrase to catch the exception if it occures
		}  catch (IOException | ParseException e) {
            System.out.println("Sorry, an Error has happened while reading the file "+e.getMessage());
		}
	}
	
	
	/*this method adds a new item to the arraylist and then by using the method write to file 
	 * the item will be added to the file , first the method asks the user about the type of the 
	 * item (grocery / electronics ) and then continous to collect the necessary data about the item
	 * by asking and reading from the user .
	 */
	public static void addNewItem() {
		System.out.print("Enter the type of the item you want to add(Grocery/Electronics):");
		String type = input.nextLine();                  // reads the item type from the user 
		
		if(type.equalsIgnoreCase("Grocery")) {           // checks if the item is grocery
			System.out.println("Enter the item name:");   
			String name = input.nextLine();
			
			System.out.println("Enter the item brand:"); 
			String brand = input.nextLine();
			
			System.out.println("Enter the item price: ");    
			double price = input.nextDouble();
			
			System.out.println("Enter the discount% : ");
			double discount = input.nextDouble()/100;
			input.nextLine();
			
			System.out.println("Enter the expiary date (DD/MM/YYYY)");  // creates an instance of the date 
			Calendar expiaryDate = Calendar.getInstance();             // enterd by the user 
			try {                                                             // a try_ catch incase an exception occures
                expiaryDate.setTime(dateFormat.parse(input.nextLine()));  // formats the date into a string 
            } catch (ParseException e) {                             // catches the exception
                System.out.println("Error!!! ,Invalid date format.");
                return;
		}
			System.out.println("Enter the weight of the item: ");
			float weight = input.nextFloat();
			input.nextLine();
			
			
			Grocery grocery = new Grocery(name,expiaryDate,weight,brand,discount,price);  // creates a new grocery object and the order of the data is based on the order in the constructor
			stock.addStockItem(grocery);       // adds the item to the array list                                          
			writeToFile(grocery);                // writes the new item on the file                                
			
			
	  }else if(type.equalsIgnoreCase("Electronics")) {          // checks if the item is electronic
		  System.out.println("Enter the version of the item: ");    // questions to collect data about the item
		  String version=input.nextLine();                         
		  
		  System.out.println("Enter the brand of the item: ");
		  String brand = input.nextLine();
		  
		  System.out.println("Enter the type of the item (in/out)Home Appliances");
		  String itemType = input.nextLine();
		  
		  System.out.println("Enter the price of the item: ");
		  double price = input.nextDouble();
		  
		  System.out.println("Enter discount on item(%): ");
		  double discount = input.nextDouble();
		  
		  System.out.println("Enter the power of the item(watt): ");
		  double power = input.nextDouble();
		  input.nextLine();
		  // creates an electronic object using the data read from the user 
		  Electronic electronic = new Electronic(version, type,power,brand, discount,price);
		  stock.addStockItem(electronic);   // adds the object to the array list 
		  writeToFile(electronic);         // writes the new item on the file 
		  
	  }else { //a statement when the item type entered by the user is not grocery or electronic
		  System.out.println("Invalid item type , please enter a type thats within the options");
	  }
		
	}
	
	
	/*this method writes the item added on the array list to the file 
	 * by using the file writer , first the method checks if the item is either 
	 * grocery or electronic then gets the values if the items atributes using the getters 
	 * and writes them of the file .
	 */
	private static void writeToFile(StockItem item) {
		// "true" is for appending the newly added data to the file so when the method writes the data 
		// on the file the old data does not get deleted . "Data.txt" is the file name that we want to 
		// write on .
		try(FileWriter fw =  new FileWriter("Data.txt",true)){   
			if (item instanceof Grocery) {     // checks if the item is a grocery
				Grocery g = (Grocery) item;  // casting into grocery
				// place holders (%s indicates a string)and (%.2f indicates the first two decimal digits)
				fw.write(String.format("Grocery,%s,%s,%.2f,%s,%.2f,%.2f\n",  
				        g.getName(),
				        dateFormat.format(g.getExpiaryDate().getTime()), // Formatting date to string
				        g.getWeight(),
				        g.getBrand(),
				        g.getDiscount() * 100, // Convert discount to percentage
				        g.getPrice()));
			}else if(item instanceof Electronic) {   // checks if the item is an electronic 
				Electronic e = (Electronic)item;// casting into electronic
				// place holders (%s indicates a string)and (%.2f indicates the first two decimal digits)
				 fw.write(String.format("Electronic,%s,%s,%.2f,%s,%.2f,%.2f\n",
					        e.getVersion(),
					        e.getType(),
					        e.getPower(),
					        e.getBrand(),
					        e.getDiscount() , // Convert discount to percentage
					        e.getPrice()));
			}
			System.out.println("Item saved succesfully");
		} catch (IOException e) {     // a catch for the exception if it occures 
			System.out.println("Sorry, Error Writing the item on the file");
			
		}
	}
	
	
	/*
	 * this method prints the items sorted by thier brand (decending ) using comparator, 
	 * first we call the items in the array list using the getter , then we use the collections 
	 * sort method to compare and sort the items by overriding the compare method 
	 * and then a for each loop to print the items after being sorted 
	 */
	private static void sortByBrand() {
		ArrayList<StockItem> items = stock.getItems(); // getteing the items 
		
		Collections.sort(items , new Comparator<StockItem>() { // calling the sorting method using comparator
			
			/* here when overriding the items based on brand we compared item2 , item1 
			 * this way the items will be sorted in a decending order if we put them like this
			 * item1,item2 the items will be sorted in an ascending order (its the same as multiplying
			 * an equation by -1)
			 */

			@Override
			public int compare(StockItem item1, StockItem item2) {
				
				return item2.getBrand().compareTo(item1.getBrand());
			}
		});
		for(StockItem item : items) {
			System.out.println(item);
		}
	}
	
	
	/*this method compares items based on price using comparator,
	 * first we get the items from the array list of stock items that we made 
	 * using the getter , then we sort the items using collections sort method but 
	 * to do that we have to override the compare method , then the items will be sorted 
	 * based on price (decending ) and then printed by using a loop ,  
	 */
	private static void sortByPrice() {
		ArrayList<StockItem> items = stock.getItems();
		
		Collections.sort(items , new Comparator<StockItem>() {
			/*putting item2 first and then item1 sorts the items in a decending 
			 * if i put item1 , item2 then the items will be sorted in an 
			 * ascending order 
			 */
			@Override
			public int compare(StockItem item1, StockItem item2) {
				return Double.compare(item2.getPrice(), item1.getPrice());
			}															     
		});																
		for(StockItem item : items) {              // a loop to print all items after being sorted
			System.out.println(item);
		}
	}
	
	/*this method asks the user about the percentage of the discount
	 * that he would like to find items with or above , then by using a 
	 * for each loop to iterate through the array list the method searches 
	 * for itams that has a discount equal or more to the discount 
	 * percentage that the user entered , if no items have been found 
	 * then a message that indicates this will appear
	 */
	private static void printItemsWithAdiscount() {
		System.out.print("Enter discount percentage(%): ");
		double discount = input.nextDouble();   // scanner to read user input
		
		for(StockItem item : stock.getItems()) {      // for each loop to iterate through the array
			if(item.getDiscount()>= discount) {
				System.out.println(item);
			}else                               //a statement if there is no items with this condition
				System.out.println("No items have a discount more than "+discount);
		}
	}
	
	
	/*this method prints all discounted electronics by using a for each loop to iterate through the 
	 * array list ,the method first checks if the item is an electronic then if yes it checks that 
	 * it has a discount , if yes the method calculate the price of the item after discount
	 * and prints the item price before and after discount.
	 */
	private static void discountedElectronicsDetails() {
		for(StockItem item : stock.getItems() ) {    // for each loop to iterate through the array
			if(item instanceof Electronic) {         // a test to check if the item is an electronic or not
				Electronic electronic = (Electronic)item; // casting to electronic
				if(electronic.getDiscount() > 0) {      // checks if the electronic has a discount or not
					double postDiscount = electronic.getPrice() * (1-electronic.getDiscount());
					System.out.println(electronic.getBrand()+electronic.getType()+",before discount:"+electronic.getPrice()+ ", after discount:"+postDiscount);
				}
			}
		}
	}
	
	
	
	/*this method checks the expierd items by first checking if the item is a grocery and has 
	 * an expiary date using a for each loop that iterates through the array list , if yes then
	 * there is another checkup that the expiary date of the item is before todays date , if yes  
	 * then the item will be printed .
	 */
	private static void printExpierdGroceries() {
		Date date =new Date();        // defining a date object
		
		for(StockItem item : stock.getItems()) {  // for each loop to iterate through the arraylist
			if(item instanceof Grocery) {         // if statement that checks if the item is grocery
				Grocery grocery = (Grocery) item;      // casting into grocery
				if(grocery.getExpiaryDate().getTime().before(date)) {   // checking that it is expiersd
					System.out.println(grocery);    // printing expired groceries
				}
			}
		}
	}
	
	
	
	/*this method creates a clone (copy) of the array list of stock items
	 * by a loop iterating through the array list and copying each item in 
	 * the original array list to the clone and then printing the new list
	 */
	private static void cloneStockList() {
	    ArrayList<StockItem> clonedList = new ArrayList<>(); // defining the new list

	    for (StockItem item : stock.getItems()) {  // a for each loop to iterate through the array list
	        clonedList.add(item);                  // adding each item to the new list
	    } 

	    System.out.println("Cloned stock list:");    // printing the new list by using a for each loop 
	    for (StockItem item : clonedList) {          // that iterates through the new list and prints each 
	        System.out.println(item);                // item
	    }
	}
	
	
	
		

}
