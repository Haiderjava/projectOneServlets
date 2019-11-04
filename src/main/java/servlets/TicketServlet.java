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

	public void init() throws ServletException{
		
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
		TicketService ticketService = new TicketService();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			super.doGet(req, resp);
			System.out.println("get");
			resp.setStatus(200);
//			String id = req.getParameter("id");
//			
//			String amount = req.getParameter("amount");
			//UserServlet
//	
//		//	String amount = response.getWriter().toString();
//			
//			ObjectMapper om = new ObjectMapper();
//			//the follwoing code is  for testing
//			//int myMoney = 200;
//			
//			//Ticket ticket = om.readValue(request.getReader(), Ticket.class);
//		//	int myamount = ticket.getAmount();
//			
//			
//			om.writeValue(resp.getWriter(), amount);
//			
//			
			
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{
			
			System.out.println("Coming from HTML");
			//System.out.println("Username: " + request.getParameter("amount"));
			
			String id = request.getParameter("id");
			
			String amount = request.getParameter("amount");
	
		//	String amount = response.getWriter().toString();
			
			ObjectMapper om = new ObjectMapper();
			
		//	amount = om.readValue(request.getReader(), String.class);
			//the follwoing code is  for testing
			//int myMoney = 200;
			
			Ticket ticket = om.readValue(request.getReader(), Ticket.class);
				int myamount = ticket.getAmount();
			
			
			om.writeValue(response.getWriter(), myamount);
			
		  //  System.out.println("Username: " + request.getAttribute("amount"));
			//response.getWriter().write("this is the amount  " + amount);
			
			
			
		}	
			
		protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{

			
			// Jackson utility class for working with JSON
			
			ObjectMapper om = new ObjectMapper();
			
						
			//Ticket ticket = new Ticket(0, 0, null, null, null, 0, 0, 0, 0);
			
			Ticket ticket = om.readValue(request.getReader(), Ticket.class);
			
			ticket = ticketService.insert(ticket);
			
			response.setStatus(201);
			om.writeValue(response.getWriter(),ticket);			
			
		}
		
	}


