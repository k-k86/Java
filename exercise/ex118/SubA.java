package exercise.ex118;

public class SubA extends SuperA {
	private int x;
	private String y;

	public SubA(int x1, String y1, int x2, String y2 ) {
		super(x1, y1);
		this.x = x2;
		this.y = y2;
	}
	public void print(){
		super.print();
		System.out.println("これはsubA");
		System.out.println("x=" + x +",y=" + y);
	}
}
