package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	
	
	
	private static Connection conn = null;
	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loaProperties();
				String url = props.getProperty("dbURL");
				conn = DriverManager.getConnection(url, props);
				System.out.println("Conectado ao banco!");
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		
	}
	
	private static Properties loaProperties() {
		
		try (FileInputStream fS = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fS);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
		
	}
	
}
