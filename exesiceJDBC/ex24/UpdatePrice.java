package ex24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdatePrice {

	public static void main(String[] args) {
		
		final String DB_URL = "jdbc:postgresql://localhost:5432/bookdb";
		final String DB_USER = "postgres";
		final String PASSWORD = "password";
		
		final String SQL1 = "UPDATE book SET price = price + (price * 0.1) ";
		final String SQL2 = "SELECT * from book ORDER BY bookno";
		String sql = null;
		
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD)) {
			
			sql = SQL1;
			try (PreparedStatement pstmt = con.prepareStatement(sql) ) {
				int rows = pstmt.executeUpdate();
				
				System.out.println(rows + "件のデータを更新しました");
			}
			System.out.println();
			
			sql = SQL2;
			try (PreparedStatement pstmt = con.prepareStatement(sql) ) {
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					System.out.print(rs.getString("bookno") + ",");
					System.out.print(rs.getString("title") + ",");
					System.out.print(rs.getString("author") + ",");
					System.out.println(rs.getInt("price"));
				}
			}
		} catch (SQLException e) {
			System.err.println("SQL:" + sql);
			e.printStackTrace();
		}
		
	}

}
