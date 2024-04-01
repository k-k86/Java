package exercise.ex37;

public class NamesOfMonths {

	public static void main(String[] args) {
		//java.util.Scanner scan = new java.util.Scanner(System.in);
		
		String[] checkMonth = { "Junary" , "February", "March", "April", "May", "June", 
								"July", "August", "September", "October", "November", "December"};
		
		int num = Integer.parseInt(args[0]);
		
		System.out.println(checkMonth[num - 1]);
		
	}

}
