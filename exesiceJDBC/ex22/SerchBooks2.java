package ex22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SerchBooks2 {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		final String DB_URL = "jdbc:postgresql://localhost:5432/bookdb";
		final String DB_USER = "postgres";
		final String PASSWORD = "password";
		
		final String SQL = "SELECT * from book where title like ? OR author like ? AND price <= ?";
		
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD) ) {
			try (PreparedStatement pstmt = con.prepareStatement(SQL); ) {
				
				System.out.print("キーワード(署名、著者の一部)  : ");
				String author = scan.nextLine();
				
				System.out.print("価格(指定した価格以下のもの)  :");
				int price = scan.nextInt();
				
				pstmt.setString(1, "%" + author + "%");
				pstmt.setString(2,  "%" + author + "%");
				pstmt.setInt(3, price);
				
				ResultSet rs = pstmt.executeQuery();
				
				System.out.println("---検索結果---");
				int count = 0;
				while(rs.next()) {
					
					System.out.print(rs.getInt("bookno") + ".");
					System.out.print(rs.getString("title") + "(");
					System.out.print(rs.getString("author") + ") \\");
					System.out.println(rs.getInt("price") + "円");
					count++;
				}
				if(count == 0) {
					System.out.println("指定した著者の書籍は存在しません。");
					return;
				}
				System.out.println("該当する件数" + count + "件");
			
			}
			
			
		} catch (SQLException e) {
			System.err.println("SQL:" + SQL);
			e.printStackTrace();
		}
	}
}
