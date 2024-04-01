package exercise.ex33;

public class Gregorian {

	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		
		System.out.println("西暦四桁を入力してください");
		int year = scan.nextInt();
		
		if (year % 400 == 0) {
			System.out.println("year  :  " + year);
			System.out.println("A leap year.");
			
			
		} else if (year % 4 == 0 && year % 100 != 0) {
			System.out.println("year  :  " + year);
			System.out.println("A leap year.");
		} else {
			System.out.println("A common year.");
		}

	}

}
