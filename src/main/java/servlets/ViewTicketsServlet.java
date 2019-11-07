package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Credentials;
import model.Ticket;
import model.User;
import service.TicketService;

/**
 * Servlet implementation class ViewTicketsServlet
 */
public class ViewTicketsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		try {
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		super.service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		TicketService ticketService = new TicketService();

		int id = Integer.parseInt(request.getParameter("id"));

		System.out.println("View Tickets Servlet: " + id);

		ObjectMapper om = new ObjectMapper();

		List<Ticket> userticket = ticketService.viewTicketsByAuthor(id);

		response.setStatus(201);

		om.writeValue(response.getWriter(), userticket);
	}

}
