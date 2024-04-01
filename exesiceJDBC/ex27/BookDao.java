package ex27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

	protected static final String DB_URL = "jdbc:postgresql://localhost:5432/bookdb";
	protected static final String DB_USER = "postgres";
	protected static final String PASSWORD = "password";
	protected static final String JDBC_DRIVER = "org.postgresql.Driver";
	
	static {
		try { Class.forName(JDBC_DRIVER); 
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC ドライバのロードに失敗しました。");
		}
	}
	
	public static List<Book> getBookList(){
		
		List<Book> list = new ArrayList<>();
		
		final String SQL = "select * from book";
		//final String SQL2 = "select * from book where bookno = ? OR title LIKE ? OR title LIKE ?";
		
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD); 
				PreparedStatement pstmt = con.prepareStatement(SQL)) {
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Book dto = new Book();
				dto.setBookno(rs.getString("bookno"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPrice(rs.getInt("price"));
				list.add(dto);
			}
			
		} catch(SQLException e) {
			System.out.println("SQL ;" + SQL);
			e.printStackTrace();
		}
		return list;
	}
	
	public static Book getBookBy(int bookno) {
		
		final String SQL = "select * from book where bookno = ?";
		Book dto = null;
		
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD); 
				PreparedStatement pstmt = con.prepareStatement(SQL)) {
			
			pstmt.setInt(1, bookno);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto = new Book();
				dto.setBookno(rs.getString("bookno"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPrice(rs.getInt("price"));
			}
			
		} catch (SQLException e) {
			System.err.println("SQL : " + SQL);
			e.printStackTrace();
		}
		return dto;
	}
	
	public static List<Book> getBookListBy(String keyword){
		
		Book dto = null;
		List<Book> list = new ArrayList<>();
		final String SQL = "select * from book where title LIKE ? OR author LIKE ?";
		
		
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD) ){
			try(PreparedStatement pstmt = con.prepareStatement(SQL)) {
				
				pstmt.setString(1, "%" + keyword + "%");
				pstmt.setString(2, "%" + keyword + "%");
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					dto = new Book();
					dto.setBookno(rs.getString("bookno"));
					dto.setTitle(rs.getString("title"));
					dto.setAuthor(rs.getString("author"));
					dto.setPrice(rs.getInt("price"));
					list.add(dto);
				}
			}
			
		}  catch (SQLException e) {
			System.err.println("SQL : " + SQL);
			e.printStackTrace();
		}
		return list;
	}
	
}
