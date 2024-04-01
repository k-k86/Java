package exercise.ex85;

public class Counter {

	public void count() {
		count(10);
	}
	
	public void count(int max) {
		for(int i = 0; i < max; i++) {
			System.out.print("*");
		}
		//System.out.println("test");
		System.out.println();
	}
	
	public void count(String max) {
		count(Integer.parseInt(max));
		System.out.println("String max=" + max);
	}
	
}
