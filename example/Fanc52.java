package com.example;

public class Fanc52 {
	
	public static void main(String[] args) {
		
		System.out.println(f(775, 527));
		
	}
	
	public static Integer f(Integer x, Integer y) {
		
		System.out.println("y:" + y);
		System.out.println("x:" + x);
		
		if (y == 0) {
			System.out.println(" yと0が等しい");
			return x;
		}
		
		else {
			
			System.out.println(" 再帰的な呼び出し ");
			return  f(y, x % y);
		}
		
	}

}
