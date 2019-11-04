package service;

import dao.TicketDao;
import dao.UserDao;
import model.Ticket;
import model.User;

public class TicketService {

	// we have to create a validation for the input coming from the controller
	// which is Servlet.
	//using inserting, method
	
	TicketDao ticketDao = new TicketDao();
	
	public Ticket insert(Ticket ticket) {
		// verifying the amount is not 0, or less
		// after that we can insert new ticket to the reimbursemnet table.
		if(ticket.getAmount()<=60) {
			
			System.out.println("Please Enter Amount");
		}
		// we have creating inserNewTicket method in TicketDao
		Ticket insertTicket = ticketDao.checkTicket(ticket);
		return insertTicket;
	}
}
