package ex25;

public class BookdbDao {

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
}
