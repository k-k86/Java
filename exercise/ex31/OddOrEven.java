package exercise.ex31;

public class OddOrEven {

	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		
		System.out.println("整数を一つ入力してください。");
		int num = scan.nextInt();
		
		System.out.println("value(int) : " + num);
		
		if ( num % 2 == 0) {
			
			System.out.println( num + " is an even number.");
		} else if( num % 2 != 0 ) {
			System.out.println( num + " is an odd number.");
		}
		

	}

}
