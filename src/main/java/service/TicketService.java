package service;

import java.util.List;

import dao.TicketDao;
import dao.UserDao;
import model.Ticket;
import model.User;

public class TicketService {

	// we have to create a validation for the input coming from the controller
	// which is Servlet.
	//using inserting, method
	
	TicketDao ticketDao = new TicketDao();
	
	public Ticket insertNewTicket(Ticket ticket) {
		Ticket insertTicket = ticketDao.newTicket(ticket);
		System.out.println("New Ticket inserted  successfully");
		return insertTicket;
		
	}
	
	public  List<Ticket> viewTicketsByAuthor(int id) {
		 List<Ticket> viewTicket = ticketDao.getTicketsByAuthor(id);
		System.out.println("View all the tickets works");
		return viewTicket;
	}
	
	public  Ticket viewTicketById(int id) {
		 Ticket viewTicket = ticketDao.viewTicket(id);
		System.out.println("View all the tickets works");
		return viewTicket;
	}
	
	
	public Ticket approveDeny(Ticket ticket) {
		Ticket approveDenyTick = ticketDao.approveDenyTicket(ticket);
		System.out.println("Ticket approved  successfully");
		return approveDenyTick;
		
	}
	
	public  List<Ticket> viewAllTickets() {
		 List<Ticket> viewTicket = ticketDao.getTickets();
		System.out.println("View all the tickets works");
		return viewTicket;
	}
	
	
}
