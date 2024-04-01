package exercise.ex123;

import exercise.ex123.com.example.model.Company;
import exercise.ex123.com.example.model.Employee;
import exercise.ex123.com.example.model.Person;

public class InheritanceTest1 {

	public static void main(String[] args) {
		
		Company company = new Company("i-Learning", "東京都中央区");
		Person[] persons = {
				new Person("Aoki"),
				new Employee("ueda", "S001", 170401, company),
				new Employee("Endo", "S002", 170401, company),
				new Person("Okada"),
				
		};
		
		for(Person person : persons) {
			System.out.println(person);
		}

	}

}
