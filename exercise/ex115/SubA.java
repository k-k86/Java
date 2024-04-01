package exercise.ex115;

public class SubA extends SuperA {
	
	private int x;
	private String y;
	
	public SubA(int x, String y) {
		
		this.x = x;
		this.y = y;
	}
	
	public void print() {
		System.out.println("x=" + x + ",y=" + y);
	}

}
