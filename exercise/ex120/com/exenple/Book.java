package exercise.ex120.com.exenple;

public class Book {
	private String title;
	private String author;
	private int price;
	private int stock;

	public Book(String title, String author, int price, int stock) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.stock = stock;
	}

	public String getInfo() {
		return title + "(" + author + "):" + price + ":" + stock;
	}
	
	@Override
	public String toString() {
		return getInfo();
	}
}
