package exercise.ex118;

public class MainA {
	public static void main(String[] args) {
		SuperA supera = new SubA(1, "Super", 2, "SubA");
		supera.print();
	}
}
