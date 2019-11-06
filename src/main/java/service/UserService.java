package service;


import dao.UserDao;
import model.Credentials;
import model.User;

public class UserService {

	UserDao userDao = new UserDao();
	

	public User userLoginService(Credentials cred) {
		// taking the user name from the input
		User login = userDao.getUser(cred.getUsername());

		if (login == null) {
			return null;
		}

		String dataBaseUserName = login.getUser_name();
		String dataBasePass = login.getUser_pass();

		String inputUserName = cred.getUsername();
		String inputPassword = cred.getPassword();

		if (dataBaseUserName.equals(inputUserName) & dataBasePass.equals(inputPassword)) {

			System.out.println("login successful");
			System.out.println(login.getUser_id());

			return login;
		}
		return null;
	}



}
