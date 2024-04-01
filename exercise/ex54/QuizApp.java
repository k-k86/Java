package exercise.ex54;

import java.util.Scanner;

public class QuizApp {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("Q, The codename of java SE 5 is known as its;");
			System.out.println("1.Mountain Line 2.Tiger 3.Leopard");
		
			int answer = scan.nextInt();
			System.out.print("answer >" + answer);
			
			if(answer == 1 || answer == 3) {
				System.out.println("Boo! WRONG ANSWER!");
				System.out.println();
			} else {
				System.out.println("Good! You are genias!");
				return;
			}
		
			
		}
		
	}

}
