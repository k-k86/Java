package exercise.ex75;

public class Sortation {

	public static void main(String[] args) {
		
		if(args.length < 1) {
			
			System.out.println("Usage : java Sortation <number>");
			return;
		}
		
		int[] intArray = parseIntArray(args);
		print("Before", intArray);
		
		
		for(int i = 0; i < intArray.length; i++){
			for(int j = i + 1; j < intArray.length; j++) {
				
				if(intArray[i] > intArray[j]) {
				
					int keep = intArray[j];
					intArray[j] = intArray[i];
					intArray[i] = keep;
					
				}
			}
			
		}
		print("After ", intArray);
		
	}
	
	private static int[] parseIntArray(String[] strArray) {
		
		int[] intArray = new int[strArray.length];
		
		for(int i = 0; i < strArray.length; i++) {

			intArray[i] = Integer.parseInt(strArray[i]);
		}
		return intArray;
	}
	
	private static void print(String title, int[] array) {
		
		System.out.print(title + " [ ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("]");
		
	}
}

		/**
		int n = args.length;
		int[] num = new int[n];
		
		System.out.print("Before  [ ");
		for(int i = 0; i < args.length; i++) {
			System.out.print(args[i] + " ");
			num[i] = Integer.parseInt(args[i]);
		}
		System.out.println("] ");
		

		
		
		System.out.print("After   [ ");
		for (int nums : num) {
			System.out.print(nums + " ");
		}System.out.println("]");
		
	}
	*/

