package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Credentials;
import model.User;
import util.ConnectionUtil;

//after creating user class for 
	//getter we have to make the return object from user type
public class UserDao {

	//This will return all the data of the users.
	public List<User> getAllUsers() {
		// complete this method to return a list type 
		try(Connection conn = ConnectionUtil.getConnection() ) {
			
			String sql = "select * from  users";
			PreparedStatement  ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List <User> users = new ArrayList();
			while (rs.next()) {
				User user = getUser(rs);
				users.add(user);
			}
			return users;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
						
		}
		
} 
	
	
	

	
private User getUser(ResultSet rs)throws SQLException{
	 int id = rs.getInt("user_id");
	 String userName = rs.getString("user_name");
	 String password = rs.getString("user_pass");
	 String firstMame = rs.getString("first_name");
	 String LastName = rs.getString("last_name");
	 String email = rs.getString("user_email");
	 int userRole = rs.getInt("user_role_id");
	 
	 User user = new User(id,userName,password,firstMame,LastName,email,userRole);
	 return user;

}
	

 public List<User> viewStatus(int UserInputId){
	 
	 String viewStatusQuerey = "select reimbursement.r_id, reimbursement.amount , status.status_name, reimbursement.description\r\n" + 
	 		"from reimbursement\r\n" + 
	 		"join status\r\n" + 
	 		"on reimbursement.r_status_id = status.status_id \r\n" + 
	 		"where reimbursement.r_id = ?;";
	int userInput = UserInputId;
		try(Connection conn = ConnectionUtil.getConnection() ) {
						
			PreparedStatement  ps = conn.prepareStatement(viewStatusQuerey);
			ps.setInt(1, userInput);
			ResultSet rs = ps.executeQuery();
			List <User> users = new ArrayList();
			while (rs.next()) {
				User user = getUser(rs);
				users.add(user);
			}
			return users;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
						
		}
	 	 
 	}
 
 
	public Credentials userLogin(Credentials credentials) {
		
		try(Connection conn = ConnectionUtil.getConnection() ) {
			
			String sql = "select * from  users";
			PreparedStatement  ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
							
			while (rs.next()) {
				String dataBaseUserName = rs.getString("user_name");
				String dataBasePass = rs.getString("user_pass");
				
				String inputUserName = credentials.getUserName();
				int inputPassword = credentials.getPassword();
				
				if(dataBaseUserName.equals(inputUserName) & dataBasePass.equals(Integer.toString(inputPassword))) {
					
					System.out.println("login successful");
					return credentials;
				}break;
			}
			credentials.setUserName("");
			credentials.setPassword(999);
			return credentials;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
						
		}
		
	} 	
	
	/*
	public void userLogin() {
		
		try(Connection conn = ConnectionUtil.getConnection() ) {
			
			String sql = "select * from  users";
			PreparedStatement  ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
							
			while (rs.next()) {
				String dataBaseUserName = rs.getString("user_name");
				String dataBasePass = rs.getString("user_pass");
				System.out.println("login successful "+dataBaseUserName);
				System.out.println("login successful "+dataBasePass);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
				
		}
		
	} 	
  */
 }