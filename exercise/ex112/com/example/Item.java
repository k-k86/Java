package exercise.ex112.com.example;

public class Item {
	
	private String name;
	private int price;
	
	public Item() {
		
	}
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String toString() {
		return name + ", " + price;
	}

}
