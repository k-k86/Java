package exercise.ex79;

public class Main {

	public static void main(String[] args) {
		
		Person person = new Person();
		
		person.name = "Suzuki";
		person.phoneNumber = "090-1234-5678";
		
		person.printInfo();
		
		person.phoneNumber = "080-9999-9999";
		person.printInfo();		
	}

}
