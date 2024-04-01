package exercise.ex66;

public class Item {
	
	String name;
	int price;

	Item(String name, int price) {
		this.name = name;
		this.price = price;
		
	}
	
	Item() {
		
	}
	String getInfo() {
		return name + "(" + price + ")";
	}

}
