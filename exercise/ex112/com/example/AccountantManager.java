package exercise.ex112.com.example;



public class AccountantManager {
	
	public static void main(String[] args) {
		
		Accountant ac = new Accountant(5);
		ac.add(new Item("pen",100));
		ac.add(new Item("eraser",50));
		ac.add(new Item("glue",150));
		ac.add(new Item("ink",350));
		ac.add(new Item("note",500));
		ac.add(new Item("postit",600));
		ac.printAll();

		System.out.println("total " + ac.total()
			+ "(" + Accountant.taxRate + "%)");
		Accountant.taxRate = 8;
		System.out.println("total " + ac.total()
			+ "("  + Accountant.taxRate + "%)");
	}
}
