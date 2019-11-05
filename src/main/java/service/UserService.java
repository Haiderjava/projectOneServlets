package service;

import dao.UserDao;
import model.Credentials;
import model.User;

public class UserService {

	UserDao userDao = new UserDao();

	public User userLoginService(Credentials cred) {

		User login = userDao.getUser(cred.getUserName());
		
		if(login == null) {
			return null;
		}

		String dataBaseUserName = login.getUser_name();
		String dataBasePass = login.getUser_pass();

		String inputUserName = cred.getUserName();
		String inputPassword = cred.getPassword();

		if (dataBaseUserName.equals(inputUserName) & dataBasePass.equals(inputPassword)) {

			System.out.println("login successful");
			return login;
		}
		return null;
	}
}
