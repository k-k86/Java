package ex27;

import java.util.List;
import java.util.Scanner;

public class SerchBooks3 {

	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("---全権表示---");
		List<Book> books = BookDao.getBookList();
		for(Book book : books) {
			
			System.out.println(book);
		}
		System.out.println();
		
		System.out.println("[検索条件]");
		System.out.print("書籍番号 :");
		
		int bookno = scan.nextInt();
		Book bookobj = BookDao.getBookBy(bookno);
		
		if(bookobj == null) {
			System.out.println("検索条件に一致する書籍はありません");
		} else {
			System.out.println(bookobj);
		}
		System.out.println();
		
		System.out.println("[検索条件]");
		System.out.print("キーワード(書名or著者の一部) :");
		
		String keyword = scan.next();
		books = BookDao.getBookListBy(keyword);
		System.out.println(">該当する件数: " + books.size() + "件");
		
		for(Book book : books) {
			System.out.println(book);
		}
		
	}

}
