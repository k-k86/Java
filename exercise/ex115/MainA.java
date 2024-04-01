package exercise.ex115;

public class MainA {

	public static void main(String[] args) {
		
		SuperA supera = new SuperA(1, "SuperA");
		SubA suba = new SubA(2, "SubA");
		
		supera.print();
		System.out.println("---");
		suba.print();

	}

}
