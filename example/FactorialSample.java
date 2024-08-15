package com.example;

public class FactorialSample {
	
	public static void main(String[] args) {
		
		int result = factorial(4);
		
		System.out.println(result);
		
	}
	
	static int factorial(int n) {
		
		if(n == 0) {
			return 1;
		}
		//イ
//		return factorial(n - 1);
		//カ
		return n * factorial(n -1);

		
	}

}
