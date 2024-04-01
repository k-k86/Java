package exercise.ex50;

public class BarGraph {

	public static void main(String[] args) {
		
		if(args.length < 1) {
			
			System.out.println("Usage : java BarGrapha <number>");
			return;
		}
		
		String ast = "*";
		
		for (int i = 0; i < args.length; i++) {
			
			int num = Integer.parseInt(args[i]);
			System.out.print(num + "\t");
			
			for(int j = 1; j <= num; j++) {
				
				System.out.print(ast);
			}
			System.out.println();
		}
		
		
	}
}
