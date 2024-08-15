package com.example;

public class CalcHash {

	static Integer[] hashArray = {-1,-1,-1,-1,-1};

	public static void main(String[] args) {
		
		add(3);
		add(18);
		add(11);
		
		int count = 1;
		
		for(Integer curr : hashArray) {
			
			if(count == hashArray.length) {
				System.out.print(curr);
			} else {
				System.out.print(curr + ",");
			}
			
			count++;
		}

	}

	private static Boolean add(Integer value){

		int i = calcHash1(value) -1;

		if(hashArray[i] == -1) {

			hashArray[i] = value;
			return true;
			
		} else {
			i = calcHash2(value) -1;
			if(hashArray[i] == -1) {
				hashArray[i] = value;
				return true;
			}
		}
		return false;

	}

	private static int calcHash1(int value) {
		return (value % hashArray.length) + 1;
	}

	private static int calcHash2(int value) {
		return ((value + 3) % hashArray.length) + 1;
	}

}
