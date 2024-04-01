package exercise.ex92.com.exemple;

import java.util.Scanner;

import exercise.ex92.com.exemple.model.Birthday;

/**
 * Birthdayクラスをテストするクラス
 * 
 * @author i-Learning
 * @version 1.0
 * @see Birthday
 */
public class BirthdayTester {

	/**
	 * クラスBirthdayのインスタンスを生成してテストする。
	 * 
	 * <ul>
	 * 	<li>標準入力から今日の日付を受け取る。</li>
	 * 	<li>Birthdayのインスタンスを生成する。</li>
	 * 	<li>生成したインスタンスの今日現在の年齢を求めて出力する。</li>
	 * 	<li>プログラムの開始および終了メッセージを出力する。</li>
	 * </ul>
	 * @param args 利用しない。
	 */
	public static void main(String[] args) {
		
		
		System.out.println("*** Birthday test start ***");
		Scanner scan = new Scanner(System.in);
		System.out.println("today (yyyymmdd) > ");
		
		int today = scan.nextInt();
		
		Birthday birthday1 = new Birthday(19940412);
		int age1 = birthday1.getAge(today);
		
		System.out.println(birthday1.toString() + "(" + age1 + "歳)");
		
		Birthday birthday2 = new Birthday(19940413);
		int age2 = birthday2.getAge(today);
		System.out.println(birthday2 + "(" + age2 + "歳)");
		
		System.out.println("*** Birthday test stop ***");
	}

}
