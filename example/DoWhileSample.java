package com.example;

import java.util.Random;

public class DoWhileSample {
	
	public static void main(String[] args) {
		
		System.out.println("doWhileのサンプルです。1になったら終了します");
		
		Random rand = new Random();
		Integer temp;
		
		do {
			
			temp = rand.nextInt(5);
			
			System.out.println("現在の値:" + temp);
			
		} while (temp != 1);
		
		System.out.println("条件が義の時だけ処理される");
		
	}
}
