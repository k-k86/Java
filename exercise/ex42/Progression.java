package exercise.ex42;

public class Progression {

	public static void main(String[] args) {
		
		if(args.length != 1) {
			
			System.out.println("Usage  :  java Progression<max_number>");
			return;
		}
		int num = Integer.parseInt(args[0]);
		
		int total = 0;
		for(int i = 1; i <= num; i++ ) {
			
			System.out.print(i + " ");
			total = i + total;
			if(i % 3 == 0) {
				System.out.println();
			}
			
		}
		System.out.println();
		System.out.println("total = " + total);
		
	}

}
