package exercise.ex108.com.example.model;

public class Human {
	
	private String name;
	private Health health;
	
	public Human() {
		
	}
	
	public Human(String name, double height, double weight) {
		this.name = name;
		health = new Health(height, weight);
	}
	
	public String toString() {
		return name + ":" + health;
	}

}
