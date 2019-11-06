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
		// verifying the amount is not 0, or less
		// after that we can insert new ticket to the reimbursemnet table.
		if(ticket.getAmount()==0) {
			
			System.out.println("Please Enter Amount");
		}
		// we have creating inserNewTicket method in TicketDao
		Ticket insertTicket = ticketDao.newTicket(ticket);
		System.out.println("New Ticket inserted  successfully");
		return insertTicket;
		
	}
	
	public  List<Ticket> viewAllTickets(Ticket ticket) {
		 List<Ticket> viewTicket = ticketDao.checkTicket(ticket);
		System.out.println("View all the tickets works");
		return viewTicket;
		
	}
	
	
	public Ticket approveDeny(Ticket ticket) {
	
		// we have creating inserNewTicket method in TicketDao
		Ticket approveDenyTick = ticketDao.approveDenyTicket(ticket);
		System.out.println("Ticket approved  successfully");
		return approveDenyTick;
		
	}
	
	
}
