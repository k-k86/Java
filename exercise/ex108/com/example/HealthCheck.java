package exercise.ex108.com.example;

import exercise.ex108.com.example.model.Human;

public class HealthCheck {

	public static void main(String[] args) {
		
		Human[] humans = new Human[3];
		humans[0] = new Human("Tanaka", 165.3, 48.5);
		humans[1] = new Human("Sasaki", 173.5, 63.7);
		humans[2] = new Human("Wada", 185.0, 95.2);
		
		
		for(Human human : humans) {
			
			System.out.println(human.toString());
		}
	}

}
