package exercise.ex80;

public class Main {

	public static void main(String[] args) {
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Customer c3 = c2;

		c1.id = 100;
		c2.id = 200;
		c3.id = 300;

		c1.name = "Suzuki";
		c2.name = "Satou";
		c3.name = "Tanaka";

		System.out.println("c1:" + c1.id + "/" + c1.name);
		System.out.println("c2:" + c2.id + "/" + c2.name);
		System.out.println("c3:" + c3.id + "/" + c3.name);
	}

}
