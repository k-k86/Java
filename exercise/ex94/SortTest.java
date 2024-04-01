package exercise.ex94;

public class SortTest {

	public static void main(String[] args) {
		
		String str1 = "orange";
		String str2 = "apple";
		
		System.out.println(str1.compareTo(str2));
		System.out.println(str2.compareTo(str1));
		
		String[] str_array = {"orange", "pineappele", "apple", "strawberry", "peaches"};
		
		for(int i = 0; i < str_array.length; i++){
			for(int j = i + 1; j < str_array.length; j++) {
				
				if(str_array[i].compareTo(str_array[j]) > 0) {
				
					String keep = str_array[j];
					str_array[j] = str_array[i];
					str_array[i] = keep;
					
				}
			}
		}
		for(String str : str_array) {
			
			System.out.println(str);
		}
		
		
	}

}
