package exercise.ex91;

public class Main {

	public static void main(String[] args) {
		
		Item item1 = new Item(101, "watch");
		System.out.println("counter:" + Item.counter);
		
		Item item2 = new Item(102, "bell");
		System.out.println("counter:" + Item.counter);
		System.out.println("counter:" + item1.counter);
		
	}

}
