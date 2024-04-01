package exercise.ex122.com.example.model;

public class Item {
	
	private String itemId;
	private String itemName;
	private int itemPrice;
	
	public Item() {
		
	}
	
	public Item(String itemId, String itemName, int itemPrice) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		
	}
	
	public int getPrice() {
		return itemPrice;
	}
	
	public String toString() {
		return "Item[id=" + itemId +",name=" + itemName + ".price=" + itemPrice +"]";
	}
	

}
