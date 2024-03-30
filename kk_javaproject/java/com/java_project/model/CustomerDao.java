/**
 * 
 */
package com.java_project.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 顧客情報を操作するクラス。
 * 主にDBにSQLを実行する。
 */
public class CustomerDao extends JavaProjectDao {

	/**
	 * 受け取った顧客情報をcustomer_listにINSERTする。登録が完了すれば戻り値として1を返す。登録が失敗すればnullを返す。
	 * @param 顧客情報
	 * @return 登録が完了すれば1。失敗すればnull。
	 */
	public static Integer InsertCustomer(Customer customer) {
		
		Integer rows = null;
		Date sqlBirthDate = null;
		
		final String SQL = "INSERT into customer_list "
				+ "( customer_name, customer_name_kana, customer_sex, customer_birth_date,"
				+ " customer_address, customer_tell, customer_mail, customer_reg_date)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, now())";
		
		
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(SQL); ) {
			
			if(customer.getCustomer_birth_date() != null ) {
				sqlBirthDate = Date.valueOf(customer.getCustomer_birth_date());
			}
			
			pstmt.setString(1, customer.getCustomer_name());
			pstmt.setString(2, customer.getCustomer_name_kana());
			pstmt.setInt(3, customer.getCustomer_sex());
			//LocalDate型からsql.date型に変換してパラムにセット
			pstmt.setDate(4, sqlBirthDate);
			pstmt.setString(5, customer.getCustomer_address());
			pstmt.setString(6, customer.getCustomer_tell());
			pstmt.setString(7, customer.getCusotmer_mail());
			
			rows = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.err.println("SQL ;" + SQL);
			e.printStackTrace();
		}
		return rows;
	}
	
	/**
	 * 顧客情報を更新するメソッド。戻り値は更新した顧客情報。
	 * 更新する項目は1件のみ選択される。
	 * @param updateKey 更新する顧客情報のID(カラム名customer_id)。
	 * @return list 更新された顧客情報が格納されているList。
	 */
	public static List<Customer> UpdateCustomer(Integer[] updateKey, Customer customer) {
		
		Date sqlBirthDate = null;
		Date sqlRegDate = null;
		List<Customer> list = new ArrayList<>();
		int count = 0;
		String sql = null;
		final String SQL1 = " UPDATE customer_list SET "
				+ " customer_name = ? , customer_name_kana = ? ,"
				+ " customer_sex = ? , customer_birth_date = ? , customer_address = ? ,"
				+ " customer_tell = ? , customer_mail = ? , customer_reg_date = ? "
				+ " WHERE customer_id = ? ";
		
		final String SQL2 = " SELECT * from customer_list WHERE customer_id = ? ";
		
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD) ) {
			sql = SQL1;
			
			try	(PreparedStatement pstmt = con.prepareStatement(sql) ) {
			
				
				if(customer.getCustomer_birth_date() != null ) {
					sqlBirthDate = Date.valueOf(customer.getCustomer_birth_date());
				}
				if(customer.getCustomer_reg_date() != null ) {
					sqlRegDate = Date.valueOf(customer.getCustomer_reg_date());
				}
				
				pstmt.setString(1, customer.getCustomer_name());
				pstmt.setString(2, customer.getCustomer_name_kana() );
				pstmt.setInt(3, customer.getCustomer_sex());
				//LocalDate型からsql.date型に変換してパラムにセット
				pstmt.setDate(4,sqlBirthDate);
				pstmt.setString(5, customer.getCustomer_address());
				pstmt.setString(6, customer.getCustomer_tell());
				pstmt.setString(7, customer.getCusotmer_mail());
				pstmt.setDate(8, sqlRegDate);
				pstmt.setInt(9, updateKey[0]);
				
				System.out.println("postgres     > " + pstmt.toString());
			
				count = pstmt.executeUpdate();
				
				if(count == 0) {
					return list = null;
				}
			
			}
			
			sql = SQL2;
			try ( PreparedStatement pstmt = con.prepareStatement(sql) ) {
				
				
				pstmt.setInt(1, updateKey[0]);
				
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					Customer dto = new Customer();
					
					dto.setCustomer_id(rs.getInt("customer_id"));
					dto.setCustomer_name(rs.getString("customer_name"));
					dto.setCustomer_name_kana(rs.getString("customer_name_kana"));
					dto.setCustomer_sex(rs.getInt("customer_sex"));
					//sql.date型からLocalDate型に変換
					if (rs.getDate("customer_birth_date") != null) {
						dto.setCustomer_birth_date(rs.getDate("customer_birth_date").toLocalDate());
					}
					dto.setCustomer_address(rs.getString("customer_address"));
					dto.setCustomer_tell(rs.getString("customer_tell"));
					dto.setCustomer_mail(rs.getString("customer_mail"));
					dto.setCustomer_reg_date(rs.getDate("customer_reg_date").toLocalDate());
					
					list.add(dto);
				}
			}
			
		} catch(SQLException e) {
			System.err.println("SQL ;" + sql);
			e.printStackTrace();
		}
		return list;
		
	}
	
	/**
	 * 顧客情報を削除するメソッド。戻り値は削除した件数。
	 * 削除する項目をチェックボックスで選択するため、複数選択の可能性がある。
	 * だからparamで受け取るkeyは配列にして受け取る。
	 * @param deleteKey 削除する顧客情報のID(カラム名customer_id)。
	 * @return count 顧客情報を削除した件数。
	 */
	public static Integer DeleteCustomer(Integer[] customerKey) {
		
		int count = 0;
		final String SQL = "DELETE from customer_list WHERE customer_id = ? ";
		
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(SQL); ) {
			
			for(int i = 0; i < customerKey.length; i++) {
				pstmt.setInt(1, customerKey[i]);
				pstmt.executeUpdate();
				count++;
			}
			
			  if(count == 0) {
				return null;
			}
			 
		} catch(SQLException e) {
			System.err.println("SQL ;" + SQL);
			e.printStackTrace();
		}
		
		return count;
	} 
	
	/**
	 * 顧客情報(customer_list)を全権取得するメソッド。
	 * @return customer_listの全件
	 */
	public static List<Customer> AllCustomerList(){
		
		List<Customer> list = new ArrayList<>();
		final String SQL = "select * from customer_list";
		
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD); 
				PreparedStatement pstmt = con.prepareStatement(SQL)) {
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Customer cst = new Customer();
				
				cst.setCustomer_id(rs.getInt("customer_id"));
				cst.setCustomer_name(rs.getString("customer_name"));
				cst.setCustomer_name_kana(rs.getString("customer_name_kana"));
				cst.setCustomer_sex(rs.getInt("customer_sex"));
				//sql.date型からLocalDate型に変換
				if (rs.getDate("customer_birth_date") != null) {
					cst.setCustomer_birth_date(rs.getDate("customer_birth_date").toLocalDate());
				}
				cst.setCustomer_address(rs.getString("customer_address"));
				cst.setCustomer_tell(rs.getString("customer_tell"));
				cst.setCustomer_mail(rs.getString("customer_mail"));
				//sql.date型からLocalDate型に変換
				cst.setCustomer_reg_date(rs.getDate("customer_reg_date").toLocalDate());
				
				list.add(cst);
			}
			
		} catch(SQLException e) {
			System.err.println("SQL ;" + SQL);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 顧客情報をIDで検索するために選択された顧客情報を取得する為のメソッド。
	 * @return 選択された顧客情報のList
	 */
	public static List<Customer> SelectCustomerListById(Integer[] customerKey){
		
		List<Customer> list = new ArrayList<>();
		String sql = "SELECT * FROM customer_list WHERE customer_id = ? ";
		
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(sql); ) {
			
			for(int i = 0; i < customerKey.length; i++) {
				pstmt.setInt(1, customerKey[i]);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					
					Customer cst = new Customer();
					
					cst.setCustomer_id(rs.getInt("customer_id"));
					cst.setCustomer_name(rs.getString("customer_name"));
					cst.setCustomer_name_kana(rs.getString("customer_name_kana"));
					cst.setCustomer_sex(rs.getInt("customer_sex"));
					//日付データの中にNULLが入ってる状態でLocalDateに変換するとヌルポが起きるので、ifで条件を付ける
					if (rs.getDate("customer_birth_date") != null) {
						cst.setCustomer_birth_date(rs.getDate("customer_birth_date").toLocalDate());
					}
					cst.setCustomer_address(rs.getString("customer_address"));
					cst.setCustomer_tell(rs.getString("customer_tell"));
					cst.setCustomer_mail(rs.getString("customer_mail"));
					//sql.date型からLocalDate型に変換
					cst.setCustomer_reg_date(rs.getDate("customer_reg_date").toLocalDate());
					
					list.add(cst);
				}
				
			}
			
		} catch(SQLException e) {
			System.err.println("SQL ;" + sql);
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 複数検索を実行するメソッド。戻り値は検索結果が入ったlist。
	 * 検索条件に一致する情報が一つもなければ戻り値としてnullを返す。
	 * @param customer 顧客情報。
	 * @return 顧客情報が入ったList。検索条件に一致した情報がなければnull。
	 */
	public static List<Customer> CustomerConditionsSerach(Customer customer) {
		
		//日付の初期化
		Date sqlBirthDate = null;
		Date sqlRegDate = null;
		
		//文字列の初期化(あいまい検索の為の処理)
		String name = null;
		String name_kana = null;
		String address = null;
		String tell = null;
		String mail = null;
		//int count = 0;
		List<Customer> list = new ArrayList<>();
		
		String sql = "SELECT * from customer_list WHERE "
				+ "( customer_id = ? AND customer_name LIKE ? AND customer_name_kana LIKE ? AND "
				+ "customer_sex = ? AND customer_birth_date = ? AND customer_address LIKE ? AND "
				+ "customer_tell LIKE ? AND customer_mail LIKE ? AND customer_reg_date = ? ) IS NOT FALSE";
		
		/**
		StringBuilder str_builder = new StringBuilder();
		
		if( !"".equals(customer.getCustomer_id()) ) {
			str_builder.append("customer_id = ? AND ");
			count++;
		}
		if( !"".equals(customer.getCustomer_name()) ) {
			str_builder.append("customer_name LIKE ? AND ");
			count++;
		}
		if(!"".equals(customer.getCustomer_name_kana()) ) {
			str_builder.append("customer_name_kana LIKE ? ");
			count++;
		}
		
		//sql = sql + str_builder.toString();
		*/
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(sql) ){
			//各データをnullチェック
			if(customer.getCustomer_birth_date() != null ) {
				sqlBirthDate = Date.valueOf(customer.getCustomer_birth_date());
			}
			if(customer.getCustomer_reg_date() != null ) {
				sqlRegDate = Date.valueOf(customer.getCustomer_reg_date());
			}
			//データがある時だけあいまい検索するために%で文字を囲む
			if(customer.getCustomer_name() != null ) {
				name = "%" + customer.getCustomer_name() + "%";
			}
			if(customer.getCustomer_name_kana() != null ) {
				name_kana = "%" + customer.getCustomer_name_kana() + "%";
			}
			if(customer.getCustomer_address() != null ) {
				address = "%" + customer.getCustomer_address() + "%";
			}
			if(customer.getCustomer_tell() != null ) {
				tell = "%" + customer.getCustomer_tell() + "%";
			}
			if(customer.getCusotmer_mail() != null ) {
				mail = "%" + customer.getCusotmer_mail() + "%";
			}
			//プレースホルダにセット
			pstmt.setObject(1, customer.getCustomer_id());
			pstmt.setString(2, name);
			pstmt.setString(3, name_kana );
			pstmt.setObject(4, customer.getCustomer_sex() );
			pstmt.setDate( 5, sqlBirthDate );
			pstmt.setString(6, address );
			pstmt.setString(7, tell );
			pstmt.setString(8, mail );
			pstmt.setDate( 9, sqlRegDate);
			
			System.out.println("postgres     > " + pstmt.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Customer dto = new Customer();
				
				dto.setCustomer_id(rs.getInt("customer_id"));
				dto.setCustomer_name(rs.getString("customer_name"));
				dto.setCustomer_name_kana(rs.getString("customer_name_kana"));
				dto.setCustomer_sex(rs.getInt("customer_sex"));
				//日付データの中にNULLが入ってる状態でLocalDateに変換するとヌルポが起きるので、ifで条件を付ける
				if (rs.getDate("customer_birth_date") != null) {
					dto.setCustomer_birth_date(rs.getDate("customer_birth_date").toLocalDate());
				}
				//dto.setCustomer_birth_date( rs.getDate("customer_birth_date") );
				dto.setCustomer_address(rs.getString("customer_address"));
				dto.setCustomer_tell(rs.getString("customer_tell"));
				dto.setCustomer_mail(rs.getString("customer_mail"));
				dto.setCustomer_reg_date(rs.getDate("customer_reg_date").toLocalDate());
				
				list.add(dto);
			}
			if(list.size() == 0) {
				return null;
			}
			
		} catch (SQLException e) {
			System.err.println("SQL : " + sql);
			e.printStackTrace();
		}
		
		return list;
	}
	
}
