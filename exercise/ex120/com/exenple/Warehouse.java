package exercise.ex120.com.exenple;

public class Warehouse {
	
	private static final int SIZE = 3;
	private int stackIndex;
	Book[] books = new Book[SIZE];
	
	public void push(Book book) {
		
		if(stackIndex < books.length) {
			books[stackIndex++] = book;
		} else {
			System.out.println("stack overflow!!");
		}
	}
	
	public Book pop() {
		
		if(stackIndex > 0) {
			return books[--stackIndex];
		}
		return null;
	}

}
