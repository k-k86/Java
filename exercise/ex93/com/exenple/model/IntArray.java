package exercise.ex93.com.exenple.model;

public class IntArray {
	
	private int[] array;
	
	/**
	 * 引数としてint型の配列を受け取り、受け取った配列をフィールド変数にセットする。
	 * 配列の要素数が0の場合はメッセージを出力する。
	 * @param array
	 */
	public IntArray(int[] array) {
		
		if(array.length == 0) {
			System.out.println("IntArray : array is empty.");
		}
		this.array = array;
	}
	/**
	 * フィールドにセットされた配列の要素数を返す
	 * @return 配列の要素数
	 */
	public int size() {
		return array.length;
	}
	/**
	 * フィールドにセットされた配列の合計値を返す
	 * @return 配列の合計値。配列の要素数が0の場合は0。
	 */
	public int sum() {
		int sum = 0;
		
		if(array.length == 0) {
			return 0;
		}
		for(int i = 0; i < array.length; i++) {
			sum = array[i] + sum;
		}
		return sum;
	}
	/**
	 * フィールドにセットされた配列の平均値を返す
	 * @return 配列の平均値。要素数が0の場合は0。
	 */
	public double avg() {
	
		double avg = 0;
		double sum = 0;
		if(array.length == 0) {
			return 0;
		}
		for(int i = 0; i < array.length; i++){
			sum = sum + array[i];
		}
		avg = sum / array.length;
		return avg;
	}
	/**
	 * フィールドにセットされた配列の中の最大値を返す
	 * @return 配列の中の最大値。要素数が0の場合は0。
	 */
	public int max() {
		int max = 0;
		if(array.length == 0) {
			return 0;
		}
		max = array[0];
		for(int i = 0; i < array.length; i++) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}
	/**
	 * フィールドにセットされた配列の中の最小値を返す
	 * @return 配列の中の最小値。要素数が0の場合は0。
	 */
	public int min() {
		int min = 0;
		if(array.length == 0) {
			return 0;
		}
		min = array[0];
		for(int i = 0; i < array.length; i++) {
			if(min > array[i]) {
				min = array[i];
			}
		}
		return min;
	}
	/**
	 * フィールドにセットされた配列のすべての要素を出力する
	 * 出力形式は [ 配列[0] 配列[1] .... 配列[n] ]
	 */
	public void print() {
		
		System.out.print("[ ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("]");
	}

}
