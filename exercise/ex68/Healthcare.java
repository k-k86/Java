package exercise.ex68;

public class Healthcare {
	
	private String name;
	private double height;
	private double weight;
	
	public Healthcare() {
		
	}

	public Healthcare(String name, double height, double weight) {
		
		this.name = name;
		this.height = height;
		this.weight = weight;
		
	}
	
	public double getBmi() {
		
		double bmi;
		height = height / 100;
		bmi = weight / (height * height);
		
		return bmi;
		
	}
	
	public String getName() {
		return name;
	}
}
