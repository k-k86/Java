package ex20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookTableViewer3 {

	public static void main(String[] args) {
		
		//final String JDBC_DRIVER = "org.postgresql.Driver";
		final String DB_URL = "jdbc:postgresql://localhost:5432/bookdb";
		final String DB_USER = "postgres";
		final String PASSWORD = "password";
		/*
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("JDBCドライバをロードしました。");
		} catch (ClassNotFoundException e) {
			System.err.println("ドライバのロードに失敗しました。");
			e.printStackTrace();
		}*/
		
		final String SQL = "select * from book WHERE title LIKE ? ";
		
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD); ) {
			try (PreparedStatement pstmt = con.prepareStatement(SQL) ) {
				
				pstmt.setString(1, "%門%");
				ResultSet rs = pstmt.executeQuery();
				System.out.println("bookno.title(author) price");
				
				while(rs.next()) {
				
					System.out.print(rs.getInt("bookno") + ".");
					System.out.print(rs.getString("title") + "(");
					System.out.print(rs.getString("author") + ") \\");
					System.out.println(rs.getInt("price") + "円");
				
				}
			}
			
		} catch (SQLException e) {
			System.err.println("SQL文の実行に失敗しました");
			e.printStackTrace();
		} 
		
	}

}
