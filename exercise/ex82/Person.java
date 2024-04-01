package exercise.ex82;

public class Person {

	private String name;
	private int age;
	
	public void setName(String value) {
		name = value;
	}
	
	public void setAge(int value) {
		age = value;
	}
	
	public void printInfo() {
		System.out.println(name + "(" + age + ")");
	}
	
}
