package exercise.ex29;

public class Calc {
	public static void main (String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);

		System.out.println("整数一つ目を入力してください。");
		int op1 = scan.nextInt();

		System.out.println("整数二つ目を入力してください。");
		int op2 = scan.nextInt();
		
		if(op1 > op2 ) {
			System.out.println("op1 > op2");
		} else if (op1 < op2 ) {
			System.out.println("op1 < op2");
		} else if(op1 == op2 ) {
			System.out.println("op1 = op2");
		}
	}
}
