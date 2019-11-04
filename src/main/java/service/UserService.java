package service;

import dao.UserDao;
import model.Credentials;
import model.User;

public class UserService {
	
	UserDao userDao = new UserDao();
	
	public Credentials userLoginService(Credentials credentials) {
		
		// do some validations
		Credentials login = UserDao.userLogin(credentials);
		return login;
		
		
		
	}
	

}
