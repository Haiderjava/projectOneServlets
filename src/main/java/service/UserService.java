package service;

import dao.UserDao;
import model.Credentials;


public class UserService {
	
	UserDao userDao = new UserDao();
	public Credentials userLoginService(Credentials cred) {
		
		//Credentials credentials = cred;
		// do some validations
		Credentials login = userDao.userLogin(cred);
		return login;
		
		
		
	}
	
	
	public Credentials inserNewTicket(Credentials cred) {
		
		//Credentials credentials = cred;
		// do some validations
		Credentials login = userDao.userLogin(cred);
		return login;
	
	

}
	
}

