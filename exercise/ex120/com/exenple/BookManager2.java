package exercise.ex120.com.exenple;

public class BookManager2 {
	
	public static void main(String[] args) {
		
		Book book1 = new Book("蜘蛛の糸","芥川龍之介",400,3);
		Book book2 = new Book("野菊の墓","伊藤左千夫",360,7);
		Book book3 = new Book("檸檬", "梶井基次郎", 420, 5);

		Warehouse house = new Warehouse();
		house.push(book1);
		house.push(book2);
		house.push(book3);
		System.out.println(house.pop().getInfo());
		System.out.println(house.pop().getInfo());
		System.out.println(house.pop().getInfo());
	}
}
