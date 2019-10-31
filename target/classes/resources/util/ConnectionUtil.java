package resources.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() {
		
		String url = "jdbc:postgresql:localhost:5432/postgres";
		try {
			
			Connection conn = DriverManager.getConnection(url, "admin","password");
			System.out.print("connection established succssfully");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.print("connection failure");
			return null;
		}
	}
	
	
}
