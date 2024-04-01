package ex7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DirverLoad {

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
		
		Connection con = null;
		Statement stmt = null;
		final String SQL = "select * from book";
		
		try {
			con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			while(rs.next()) {
				System.out.print(rs.getInt("bookno") + " ");
				System.out.print(rs.getString("title") + " ");
				System.out.print(rs.getString("author") + " ");
				System.out.println(rs.getInt("price") + "円");
			}
			
		} catch (SQLException e) {
			System.err.println("DBとの接続に失敗しました");
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
					System.out.println("DBとの切断に成功しました");
				} catch (SQLException e) {
					System.out.println("DBとの切断に失敗しました");
					e.printStackTrace();
				}
			}
		}
		
	}

}
