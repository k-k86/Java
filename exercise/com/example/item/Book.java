package exercise.com.example.item;

public class Book {
	
	private String title;
	private String name;
	private int price;
	
	public Book(){
		
	}
	
	public Book(String title, String name, int price) {
		
		this.title = title;
		this.name = name;
		this.price = price;
		
	}

	public String getInfo() {
		return '"' + title + '"' + "(" + name + "): " + price + "yen";
	}
}
