package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.UserDao;
import model.Credentials;
import model.Ticket;
import model.User;
import service.TicketService;
import service.UserService;

public class UserServlet extends HttpServlet {

	public void init() throws ServletException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	// to take care of CORS
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       response.setHeader("Access-Control-Allow-Origin", "*");
	       response.setHeader("Access-Control-Allow-Headers", "*");
	       super.service(request, response);
	   }

	// here we are calling the useService
		UserService userService = new UserService();



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		System.out.println("Coming from HTML");

		ObjectMapper om = new ObjectMapper();

		Credentials cred = om.readValue(request.getReader(), Credentials.class);

		User user = userService.userLoginService(cred);
		response.setStatus(201);

		om.writeValue(response.getWriter(), user);

	}



}
