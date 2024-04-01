package exercise.ex94.com.example;

import exercise.ex94.com.example.service.SortService;

public class SortServiceTester {

	public static void main(String[] args) {
		
		System.out.println("*** SortService test start ***");
		
		int[] int_array = {10, 20, 30, 0, -5, 5, 25};
		String[] str_array = {"orange", "pineappele", "apple", "strawberry", "peaches"};
		//SortService sort = new SortService();
		
		print("整列前", int_array);
		SortService.sort(int_array);
		print("整列後", int_array);
		
		System.out.println();
		
		print("整列前", str_array);
		SortService.sort(str_array);
		print("整列後", str_array);
		
		System.out.println("*** SortService test stop ***");
		
	}
	

	private static void print(String title, int[] array) {
		
		System.out.print(title + " [ ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("]");
		
	}

	

	private static void print(String title, String[] strArray) {
		
		System.out.print(title + " [ ");
		for(int i = 0; i < strArray.length; i++) {
			System.out.print(strArray[i] + " ");
		}
		System.out.println("]");
		
	}

	
}
