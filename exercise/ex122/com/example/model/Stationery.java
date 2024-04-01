package exercise.ex122.com.example.model;

public class Stationery extends Item {
	
	private String category;
	
	public Stationery() {
		
	}
	
	public Stationery(String itemId, String itemName, int itemPrice, String category) {
		super(itemId, itemName, itemPrice);
		this.category = category;
	}
	
	public String toString() {
		return super.toString() + ",Stationery[category=" + category + "]";
	}
	

}
