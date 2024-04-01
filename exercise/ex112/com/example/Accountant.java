package exercise.ex112.com.example;

public class Accountant {
	
	static int taxRate = 0;
	private int index;
	private Item[] itemArray;
	
	public Accountant(int size) {
		this.itemArray = new Item[size];
		
	}
	
	public void add(Item item) {
		
		if(index < itemArray.length) {
			itemArray[index++] = item;
		} else {
			System.out.println("con't add item[" + item + "]");
		}
	}
	
	public int total() {
		int total = 0;
		for(int i = 0; i < itemArray.length; i++) {
			total = itemArray[i].getPrice() + total;
		}
		return total + total * taxRate / 100;
	}
	
	public void printAll() {
		for(Item item : itemArray) {
			if(item == null) {
				break;
			}
			System.out.println(item);
		}
		System.out.println("--------------");
	}

}
