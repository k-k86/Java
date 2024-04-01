package exercise.ex116;

public class SubA extends SuperA {
	
	private int x;
	private String y;
	
	public SubA(int x, String y) {
		
		super(0, "dummy");
		this.x = x;
		this.y = y;
	}
	
	public void print() {
		super.print();
		System.out.println("subAのメソッド");
		System.out.println("x=" + y + ",y=" + x);
	}

}
