package exercise.ex38;

public class NamesOfMonths {

	public static void main(String[] args) {
		//java.util.Scanner scan = new java.util.Scanner(System.in);
		
		String[] checkMonth = { "Junary" , "February", "March", "April", "May", "June", 
								"July", "August", "September", "October", "November", "December"};
		
		if(args.length != 0) {
			int num = Integer.parseInt(args[0]);
			
			if (num >= 1 && num <= 12) {
				
				System.out.println(num);
				System.out.println(checkMonth[num - 1]);
				
			} else {
				System.out.println("引数には1～12の範囲の整数を指定してください");
				System.out.println("使用方法:  java NamesOfMonths <number>");
			}
		} else {
			
			System.out.println("使用方法:  java NamesOfMonths <number>");
		}
		
		
	}

}
