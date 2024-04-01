package exercise.ex93.com.exenple;

import exercise.ex93.com.exenple.model.IntArray;

public class IntArrayTester {

	public static void main(String[] args) {
		
		System.out.println("*** Int Array test start ***");
		
		int[] array = {10, 20, 0, -5, 5, 15};
		IntArray array1 = new IntArray(array);
		test(array1);
		
		IntArray array2 = new IntArray(new int[] {7} );
		test(array2);
		
		IntArray array3 = new IntArray(new int[0]);
		test(array3);
		
		System.out.println("*** IntArray test stop ***");
		
	}
	
	private static void test(IntArray array) {
		array.print();
		
		System.out.println("要素数=" + array.size() 
			+ ", 合計=" + array.sum() + ", 平均=" + array.avg()
			+ ", 最大=" + array.max() + ", 最小=" + array.min() );
		System.out.println();
	}
}
