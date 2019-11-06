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
       
	
public void init() throws ServletException{
		
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTicketsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		TicketService ticketService = new TicketService();

		System.out.println("Coming from View Tickets Servlet");

		ObjectMapper om = new ObjectMapper();
		
		Ticket ticket = om.readValue(request.getReader(), Ticket.class);

	
		 List<Ticket> userticket = ticketService.viewAllTickets(ticket);		
				
		response.setStatus(201);

		om.writeValue(response.getWriter(), userticket);
		
		
		//doGet(request, response);
	}

}
