package exercise.ex109.com.example;

import exercise.ex109.com.example.model.Person;
import exercise.ex109.com.example.model.Skill;

public class PersonTester {

	public static void main(String[] args) {
		
		Person[] persons = {
				new Person("Sato"), new Person("Ando"), new Person("Ito"),
		};
		
		
		persons[0].addSkill(new Skill("簿記", "2級"));
		persons[1].addSkill(new Skill("Java", "中級"));
		persons[1].addSkill(new Skill("C言語", "初級"));
		persons[1].addSkill(new Skill("運転免許", "AT限定"));
		persons[1].addSkill(new Skill("TOEIC", "600"));
		
		
		for(Person person : persons) {
			System.out.println(person);
		}
		
	}

}
