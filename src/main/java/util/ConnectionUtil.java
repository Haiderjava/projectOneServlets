package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() {
		
		String url = "jdbc:postgresql://testdb.cdzbxmzppl9m.us-east-2.rds.amazonaws.com:5432/testDB";
		try {
			
			Connection conn = DriverManager.getConnection(url, "postgres","password");
			//System.out.print("connection established succssfully");
			
			return conn;
			}catch(SQLException e) {
			e.printStackTrace();
			System.out.print("connection failure");
			
			return null;
		}
	}
	
	
}
