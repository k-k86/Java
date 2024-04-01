package exercise.ex94.com.example.service;

public class SortService {

	public static int[] sort(int[] array) {
		
		if (array == null) {
			return null;
		}
		int[] cloneArray = array.clone();
		insertSort(cloneArray);
		return cloneArray;
	}

	// 挿入法（昇順）
	public static void insertSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int save = array[i];
			int j = i - 1;
			for (; j >= 0 && array[j] > save; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = save;
		}
	}

	// String型配列のソート
	public static String[] sort(String[] array) {
		if (array == null) {
			return null;
		}
		String[] cloneArray = array.clone();
		selectSort(cloneArray);
		return cloneArray;
	}

	// 基本選択法（昇順）
	public static void selectSort(String[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i].compareTo(array[j]) > 0) {
					String work = array[i];
					array[i] = array[j];
					array[j] = work;
				}
			}
		}
	}
	
}
