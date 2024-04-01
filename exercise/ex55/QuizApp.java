package exercise.ex55;

import java.util.Scanner;

public class QuizApp {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		int count = 0;
		//Q.1
		System.out.println("Q, The codename of java SE 5 is known as its;");
		System.out.println("1.Mountain Line 2.Tiger 3.Leopard");
		
		int answerQ1 = scan.nextInt();
		System.out.print("answer >" + answerQ1);
			
		if(answerQ1 == 1 || answerQ1 == 3) {
			System.out.println("Boo! WRONG ANSWER!");
			System.out.println();
		} else {
			System.out.println("Good! You are genias!");
			System.out.println();
			count++;
		}
		
		//Q.2
		System.out.println("Q, The codename of java SE 7 is known as its;");
		System.out.println("1.Dolphin 2.Mustang 3.Whale");
			
		int answerQ2 = scan.nextInt();
		System.out.println("answer >" + answerQ2);
			
		if(answerQ2 == 2 || answerQ2 == 3) {
			System.out.println("Boo! WRONG ANSWER!");
			System.out.println();
		} else {
			System.out.println("Good! You are genias!");
			System.out.println();
			count++;
		}
			
		//Q.3
		System.out.println("Q, The codename of Eclipse 4.6 is known as its;");
		System.out.println("a.Lune b.Mars c.Neon");
			
		String answerQ3 = scan.next();
		System.out.println("answer >" + answerQ3);
			
		if("a".equals(answerQ3) || "b".equals(answerQ3)) {
			System.out.println("Boo! WRONG ANSWER!");
			System.out.println();
		} else {
			System.out.println("Good! You are genias!");
			System.out.println();
			count++;
		}
		
		System.out.println("Result ccorect answer/question count) = " + count + "/ 3");
		
	}

}
