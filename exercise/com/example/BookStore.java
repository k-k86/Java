package exercise.com.example;

import exercise.com.example.item.Book;

public class BookStore {

	public static void main(String[] args) {
		
		
		
		if (args.length > 2) {
			
			String title = args[0];
			String name = args[1];
			int price = Integer.parseInt(args[2]);
			
			Book book = new Book(title, name, price);
			
			System.out.println(book.getInfo());
			
		} else {
			System.out.println("java MusicPlayer <title> <name> <price>");
		}

	}

}
