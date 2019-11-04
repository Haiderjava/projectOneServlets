package servlettest;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Ticket;
import service.TicketService;

public class UserServletTest extends HttpServlet {

		public void init() throws ServletException{
		
				try {
					Class.forName("org.postgresql.Driver");			
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
			}
	
	// here we are calling, TicketService class.
		TicketService ticketService = new TicketService();
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{
					
			ObjectMapper om = new ObjectMapper();
			
			Ticket ticket = om.readValue(request.getReader(), Ticket.class);
			
			ticket = ticketService.insert(ticket);
			response.setStatus(201);
			om.writeValue(response.getWriter(),ticket);
					
					
		}
}