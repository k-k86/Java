package exercise.ex46;

public class Triangle {

	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("Usage  :  java Triangle <number>");
			return;
		}
		
		int num = Integer.parseInt(args[0]);
		String ast = "*";
		
		System.out.println("Triangle " + num);
		
		for(int i = 0; i <= num; i++) {
			//System.out.println("これがi" + i);
			//System.out.println("これがnum" + num);
			for (int j = 0; j < num; j++) {
				System.out.print(ast);
				//System.out.print("これがj" + j);
				
			}
			
			System.out.println();
			
			
			num = num - 1;
			i = 0;
		}
		
	}

}
