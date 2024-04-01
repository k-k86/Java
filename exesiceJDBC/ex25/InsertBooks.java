package ex25;

import java.util.Scanner;

public class InsertBooks {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Book book = new Book();
		
		
		String book_name;
		String author_name;
		int price;
		
			System.out.println("[新規登録(qで終了)]");
			
			System.out.print("書籍名 varchar(60) :");
			book_name = scan.nextLine();
			if("Q".equals(book_name.toUpperCase())) {
				return;
			} else {
				book.setTitle(book_name);
			}
			
			System.out.print("著者名 varchar(30) :");
			author_name = scan.nextLine();
			if ("Q".equals(author_name.toUpperCase())) {
				return;
			} else {
				book.setAuthor(author_name);
			}
			
			System.out.print("価格 int4(10) :");
			price = scan.nextInt();
			//入力された文字がqじゃないかチェック
			String valid_price = String.valueOf(price);
			if("Q".equals(valid_price.toUpperCase())) {
				return;
			} else {
				book.setPrice(price);
			}
			
		BookDao book_dao = new BookDao();
		int rows = book_dao.insertBook(book);
		
		if(rows == 1) {
			System.out.println("書籍の追加に成功しました");
			System.out.println(book);
		} else {
			System.out.println("書籍の追加に失敗しました");
		}
		
	}

}
