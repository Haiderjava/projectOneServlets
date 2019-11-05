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

	// here we are calling the useService
	UserService userService = new UserService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
		System.out.println("user servlet request recieved");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		System.out.println("Coming from HTML");

		ObjectMapper om = new ObjectMapper();

		Credentials cred = om.readValue(request.getReader(), Credentials.class);

		User user = userService.userLoginService(cred);
		response.setStatus(201);

		om.writeValue(response.getWriter(), user);

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// Jackson utility class for working with JSON

		// ObjectMapper om = new ObjectMapper();

		// Ticket ticket = new Ticket(0, 0, null, null, null, 0, 0, 0, 0);

		// Ticket ticket = om.readValue(request.getReader(), Ticket.class);

		// ticket = ticketService.insert(ticket);

		// response.setStatus(201);
		// om.writeValue(response.getWriter(),ticket);

	}

}
