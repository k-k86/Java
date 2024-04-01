package ex27;

import java.io.Serializable;

public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String TABLE = "BOOK";
	
	private String bookno;
	
	private String title;
	
	private String author;
	
	private int price;
	
	
	public String getBookno() {
		return this.bookno;
	}
	
	public void setBookno(String bookno) {
		this.bookno = bookno;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public  void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return "Book [" + bookno + "," + title + "," + author + "," + price + "円";
	}

}
