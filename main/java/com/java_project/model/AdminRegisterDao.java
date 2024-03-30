package com.java_project.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AdminRegisterDao extends JavaProjectDao {
	
	/**
	 * 管理者ユーザーを追加するメソッド。引数で管理者ID、パスワード、権限レベル
	 * を受け取りテーブルにINSERTする。
	 * @param 管理者ID、パスワード、権限レベル
	 * @return INSERT結果
	 */
	public static String InsertAdmin(String admin_reg_id, String admin_reg_pass, int admin_reg_lebel) {
		
		final String SQL = "INSERT into admin_user(admin_id, admin_pass, admin_level) values(?, ?, ?)";
		int rows = 0;
		String message = "";
		
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD)) {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			
			pstmt.setString(1, admin_reg_id);
			pstmt.setString(2, admin_reg_pass);
			pstmt.setInt(3, admin_reg_lebel);
			
			rows = pstmt.executeUpdate();
			
			if(rows == 0) {
				message = "登録に失敗しました。";
			} else {
				message = "登録に成功しました。";
			}
			
			
		} catch (SQLException e) {
			System.err.println("SQL:" + SQL);
			e.printStackTrace();
		}
		return message;
	}
	
	/**
	 * パスワードをハッシュ化するメソッド。戻り値はハッシュ化されたパスワード。
	 * @param ハッシュ化前の管理者パスワード
	 * @return ハッシュ化された管理者パスワード
	 */
	public static String HashAdminPass(String admin_reg_pass) {
		
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		String encodePassword = bcpe.encode(admin_reg_pass);
		
		return encodePassword;
	}

}
