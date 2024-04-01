package exercise.ex111.com.example.model;

public class Singer {
	
	private String name;
	private Birthday birth;
	
	
	public Singer(String name, int birthday) {
		this.name = name;
		this.birth = new Birthday(birthday);
	}

	public String getName() {
		return name;
	}
	
	public String getBirthday() {
		return birth.toString();
	}
	
	public int getAge(int date) {

		return 	birth.getAge(date);
	}
}
