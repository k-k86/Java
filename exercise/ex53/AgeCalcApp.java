package exercise.ex53;

import java.util.Scanner;

public class AgeCalcApp {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("What is the today?");
		System.out.print("input format : yyyymmdd > ");
		int today = scan.nextInt();
		
		while(true) {
			System.out.println();
			System.out.print("Birth day (yyyymmdd) > ");
			
			int birth_day = scan.nextInt();
			int age = (today - birth_day) / 10000;
			
			System.out.println("Age is " + age + " years old.");
			System.out.print("continue? (y/n) ;");
			
			String answer = scan.next();
			if("n".equals(answer)) {
				System.out.println();
				break;
			}
		}
		
		
	}

}
