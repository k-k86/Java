package exercise.ex123.com.example.model;

public class Person {
	
	private String name;
	
	public Person() {
		
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return "Persson[" + name + "]";
	}

}
