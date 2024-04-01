package exercise.ex83;

public class Person {

	private String name;
	private String phoneNumber;
	
	Person(String name, String phoneNumber){
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void printInfo() {
		System.out.println(name + ":" + phoneNumber );
	}
	
}
