package exercise.ex108.com.example.model;

public class Health {
	private double height;
	private double weight;
	
	public Health(double height, double weight) {
		this.height = height;
		this.weight = weight;
	}
	
	private double getBmi() {
		double meter = height / 100.0;
		return weight / (meter * meter);
	}
	
	public String toString() {
		return "身長=" + height + "cm, 体重=" + weight + "kg" + "BMI=" + getBmi();
	}

}
