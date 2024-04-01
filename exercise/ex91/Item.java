package exercise.ex91;

public class Item {

	public static int counter;
	private int id;
	private String name;
	
	public Item(int id, String name) {
		
		this.id = id;
		this.name = name;
		counter++;
		
	}
	
}
