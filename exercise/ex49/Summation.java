package exercise.ex49;

public class Summation {

	public static void main(String[] args) {
		
		if(args.length < 1) {
			
			System.out.println("Usage : java Summation <number>");
			return;
		}
		
		int total = 0;
		double avg = 0;
		
		int count = 0;
		for(int i = 0; i < args.length; i++) {
			
			int num = Integer.parseInt(args[i]);
			
			
			total = total + num;
			count++;
		}
		
		avg = (double)total / count;
		
		System.out.println(total);
		System.out.println(avg);
	}

}
