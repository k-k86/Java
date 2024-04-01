package exercise.ex30;

public class Absolute {

	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		
		System.out.println("整数を一つ入力してください。");
		int num = scan.nextInt();
		
		System.out.println("value(int) : " + num);
		if(num < 0 ) {
			
			num = num * -1;
		}
		
		System.out.println(num);
		
	}

}
