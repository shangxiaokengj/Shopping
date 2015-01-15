package rj.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

	private static final String DB_URL = "jdbc:mysql://localhost:3306/gwap";
	
	private static final String DB_USER = "root";

	private static final String DB_PSWD = "";

	public static Connection getConnection(){
		Connection conn;
		
		try {
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL,
					DB_USER, DB_PSWD);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}

		return conn;
	}
}
