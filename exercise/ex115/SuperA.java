package exercise.ex115;

public class SuperA {
	
	private int x;
	private String y;
	
	public SuperA() {
		
	}
	
	public SuperA(int x, String y) {
		this.x = x;
		this.y = y;
	}
	
	public void print() {
		System.out.println("X=" + x + ",y=" + y);
	}

}
