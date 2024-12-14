/*Name: Saif salem mustafa , ID : 1230760
 * Instructor : Mamoun Nawahda  section :2
 *
 * this is the location class, it has three atributes , two constructors , setters and getters and
 * a to string method 
 */

public class Location {
	private String street;
	private String district;
	private String city;
	
	// a no argument constructor
	public Location() {
		this.street=street;
		this.district=district;
		this.city=city;
	}
	// a constructor for all three atributes
	
	public Location(String street , String district , String city) {
		this.street=street;
		this.district=district;
		this.city=city;
	}
	
	// setters and getters
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street=street;	
	}
	
	
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district=district;
	}
	
	
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city=city;
	}
	
	// the to string method
	
	@Override
	public String toString() {
		return "City: "+getCity()+",District: "+getDistrict()
		+",Street: "+getStreet();
	}

}
