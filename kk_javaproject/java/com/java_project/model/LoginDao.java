package com.java_project.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class LoginDao extends JavaProjectDao {
	
	
	/**
	 * 引数で受け取ったログイン情報を?(プレースホルダ)にセットして、SELECT文を実行
	 * セレクト文で結果が得られなかった場合はsetLoginFlag()メソッドにfalseを入れて、結果が得られた場合はtrueを引数として渡す。
	 * 
	 * @param user(ユーザーID)
	 * @param password(ユーザーパスワード)
	 * @return ログイン情報
	 */
	public static Login getAdminUser(String user, String password) {
		
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		final String SQL = "select * from admin_user where admin_id = ?";
		Login login = new Login();
		
		
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			
			pstmt.setString(1, user);
			
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				login.setId(rs.getString("admin_id"));
				login.setPass(rs.getString("admin_pass"));
				login.setLevel(rs.getInt("admin_level"));
			}
			

			//ユーザー入力されたパスワードとハッシュ化されたパスワードが一致しているか
			if(bcpe.matches(password, login.getPass())) {
				
				login.setLoginFlag(true);
				
			} else {
				
				login.setLoginFlag(false);
			}
			
		} catch (SQLException e) {
			System.err.println("SQL:" + SQL);
			e.printStackTrace();
		}
		return login;
	}
	

}
