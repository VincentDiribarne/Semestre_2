public class Coffee {
	public String id ;
	public String name ;
	public double price ;
	
	public Coffee(String id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public String toString() {
		return "Coffee #" + this.id + " : " + this.name + " => " + this.price + " €";
	}
}

