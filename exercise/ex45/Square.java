package exercise.ex45;

public class Square {

	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("Usage  :  java Square <number>");
			return;
		}
		
		int num = Integer.parseInt(args[0]);
		String ast = "*";
		
		System.out.println("Square" + num);
		for(int i = 0; i < num; i++) {
			
			for(int j = 0; j < num; j++) {
				
				System.out.print(ast);
				
			}
			System.out.println();
			
		}
		
		
	}

}
