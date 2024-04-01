package exercise.ex106;

import java.util.Scanner;

public class PostalCodeServiceTester {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("--- 郵便番号検索サービスを開始します ---");
		while(true) {
			
			System.out.print("郵便番号 (9で終了) > ");
			int post_no = scan.nextInt();
			
			if(post_no == 9) {
				break;
			}
			
			String address = PostalCodeService.getAddress(post_no);
			if (address == null) {
				address = "該当するものが見つかりません";
			}
			System.out.println("住所 : " + address);
			
		
		}
		
		System.out.println("郵便番号が特定できる住所を入力してください");
		while(true) {
			
			System.out.print("住所 (quitで終了) > ");
			String post_add = scan.next();
			
			if("quit".equals(post_add)){
				break;
			}
			
			int post_no = PostalCodeService.getPostalCode(post_add);
			if(post_no == 0) {
				
				System.out.println("該当するものが見つかりません");;
			}
			System.out.println("郵便番号 : " + post_no);
		}
		System.out.println("--- 郵便番号検索サービスを終了します ***");
	}

}
