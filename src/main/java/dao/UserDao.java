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

	// This will return all the data of the users.
	public List<User> getAllUsers() {
		// complete this method to return a list type
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "select * from  users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<User> users = new ArrayList();
			while (rs.next()) {
				User user = extractUser(rs);
				users.add(user);
			}
			return users;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private User extractUser(ResultSet rs) throws SQLException {
		int id = rs.getInt("user_id");
		String userName = rs.getString("user_name");
		String password = rs.getString("user_pass");
		String firstMame = rs.getString("first_name");
		String LastName = rs.getString("last_name");
		String email = rs.getString("user_email");
		int userRole = rs.getInt("user_role_id");

		User user = new User(id, userName, password, firstMame, LastName, email, userRole);
		return user;

	}

	public User getUser(String username) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "select * from users where user_name = (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User returnUser = extractUser(rs);
				return returnUser; 
			}
			return null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}

	}
}