package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Credentials;
import model.Ticket;
import model.User;
import service.TicketService;
import service.UserService;

public class UserServlet extends HttpServlet {

	public void init() throws ServletException{
		
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	// here we are calling the useService 
		UserService userService = new UserService();
				
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{
			
			System.out.println("Coming from HTML");
	
			
			ObjectMapper om = new ObjectMapper();
				
			Credentials cred = om.readValue(request.getReader(), Credentials.class);
				int pass = cred.getPassword();
				String name = cred.getUserName();
				
			
			//om.writeValue(response.getWriter(), name);
			//om.writeValue(response.getWriter(), pass);
			
			cred = userService.userLoginService(cred);
			
			om.writeValue(response.getWriter(), cred);
			
			System.out.println("" + name);
			System.out.println("" + pass);
			
			
		  //  System.out.println("Username: " + request.getAttribute("amount"));
			//response.getWriter().write("this is the amount  " + amount);
			
			
			
		}	
			
		protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{

			
			// Jackson utility class for working with JSON
			
			//ObjectMapper om = new ObjectMapper();
			
						
			//Ticket ticket = new Ticket(0, 0, null, null, null, 0, 0, 0, 0);
			
		//	Ticket ticket = om.readValue(request.getReader(), Ticket.class);
			
		//	ticket = ticketService.insert(ticket);
			
		//	response.setStatus(201);
		//	om.writeValue(response.getWriter(),ticket);			
			
		}
		
	}
