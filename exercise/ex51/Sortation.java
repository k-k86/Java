package exercise.ex51;

public class Sortation {

	public static void main(String[] args) {
		
		if(args.length < 1) {
			
			System.out.println("Usage : java Sortation <number>");
			return;
		}

		int n = args.length;
		int[] num = new int[n];
		
		System.out.print("Before  [ ");
		for(int i = 0; i < args.length; i++) {
			System.out.print(args[i] + " ");
			num[i] = Integer.parseInt(args[i]);
		}
		System.out.println("] ");
		

		
		for(int i = 0; i < num.length; i++){
			for(int j = i + 1; j < num.length; j++) {
				
				if(num[i] > num[j]) {
				
					int keep = num[j];
					num[j] = num[i];
					num[i] = keep;
					
				}
			}
			
		}
		System.out.print("After   [ ");
		for (int nums : num) {
			System.out.print(nums + " ");
		}System.out.println("]");
		
	}

}
