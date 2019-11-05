package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() {
		
		String url = "jdbc:postgresql://localhost:5432/ERS";
		try {
			
			Connection conn = DriverManager.getConnection(url, "postgres","postgres");
			//System.out.print("connection established succssfully");
			
			return conn;
			}catch(SQLException e) {
			e.printStackTrace();
			System.out.print("connection failure");
			
			return null;
		}
	}
	
	
}
