package exercise.ex122.com.example.model;

public class Book extends Item {
	
	private String author;
	
	public Book() {
		
	}
	
	public Book(String itemId, String itemName, int itemPrice, String author) {
		
		super(itemId, itemName, itemPrice);
		this.author = author;
	}
	
	public String toString() {
		return super.toString() + ",Book[author=" + author + "]";
	}

}
