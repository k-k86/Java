package exercise.ex95.com.example;

import java.util.Scanner;

import exercise.ex95.com.example.service.DateService;

public class DateServiceApp {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(true) {
			
			System.out.println("[MENU] 1.日付の妥当性 2.うるう年 3.月末日 q.終了");
			System.out.print("処理番号 > ");
			String keyword = scan.next();
			
			if("q".equals(keyword.toLowerCase()) ) {
				return;
			}
			
			int key_num = Integer.parseInt(keyword);
			
			if( key_num == 1) {
				System.out.print("西暦年月日(yyyymmdd) > ");
				int date = scan.nextInt();
				boolean date_judg = false;
				date_judg = DateService.isValidDate(date);
				
				if(date_judg == true) {
					System.out.println("正しい日付です。");
				} else {
					System.out.println("日付が不正です。");
				}
				System.out.println();
			} else if(key_num == 2) {
				System.out.print("西暦年(yyyy) > ");
				int year = scan.nextInt();
				
				if(DateService.isLeapYear(year)) {
					System.out.println("うるう年です。");
				} else {
					System.out.println("平年です。");
				}
				
			} else if(key_num == 3) {
				System.out.print("西暦年月(yyyymm) > ");
				int date = scan.nextInt();
				int year = date / 100;
				int month = date % 100;
				int day = DateService.getEndOfMonth(year, month);
				
				System.out.println(year + "年" + month + "月" + day + "日");
			}
			
		}
		
	}

}
