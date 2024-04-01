package exercise.ex56;

import java.util.Scanner;

public class PostalCodeApp {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] post_no = {9012201, 9012204, 9012205, 9010206, 9012221, 9012223, 9012225, 9012227};
		String[] post_name = {"宜野湾市新城", "宜野湾市上原", "宜野湾市赤道", "宜野湾市愛知", 
				"宜野湾市伊佐", "宜野湾市大山", "宜野湾市大謝名", "宜野湾市宇地泊"};
		
		System.out.println("*** 郵便番号検索プログラムを開始します ***");
		System.out.println("郵便番号はハイフンなしで7桁で入力してください");
		
		int flag = 0;
		while(true) {
			
			System.out.print("郵便番号(quitで終了) >");
			String post_search = scan.next();
			//String end_check = String.valueOf(post_search);
			
			if("quit".equals(post_search)) {
				System.out.println("*** 郵便番号検索を終了します ***");
				return;
			}
			
			for(int i = 0; i < post_no.length; i++) {
				if(Integer.parseInt(post_search) == post_no[i]) {
					System.out.println(post_name[i]);
					flag = 1;
					break;
				} 
			}
			if(flag == 0) {
				System.out.println("該当するものが見つかりません。");
			}
			
		}
		
	}

}
