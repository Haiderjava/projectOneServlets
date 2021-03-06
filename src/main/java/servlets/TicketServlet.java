package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Ticket;
import service.TicketService;

public class TicketServlet extends HttpServlet {

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

	TicketService ticketService = new TicketService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		System.out.println("Coming from HTML");

		ObjectMapper om = new ObjectMapper();

		Ticket ticket = om.readValue(request.getReader(), Ticket.class);

		Ticket userticket = ticketService.insertNewTicket(ticket);
		om.writeValue(response.getWriter(), userticket);

	}

}
