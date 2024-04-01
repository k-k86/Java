package ex25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDao extends BookdbDao {
	
	public int insertBook(Book book) {
	
		final String SQL = "INSERT into book(title, author, price) VALUES(?, ?, ?)";
		int rows = 0;
		Integer gkey = null;
		
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD) ) {
			try(PreparedStatement pstmt = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS) ){
				
				pstmt.setString(1, book.getTitle());
				pstmt.setString(2, book.getAuthor());
				pstmt.setInt(3, book.getPrice());
				
				rows = pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				
				if(rs.next()) {
					gkey = (int) rs.getLong(1); //自動生成されたキー
					String return_key = gkey.toString();
					book.setBookno(return_key);
				}
			}
			
		} catch(SQLException e) {
			System.out.println("SQL ;" + SQL);
			e.printStackTrace();
		}
		return rows;
	}
}
