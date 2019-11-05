package maintest;


import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import dao.TicketDao;
import dao.UserDao;
import model.Ticket;
import model.User;

public class main {

	public static void main(String args[]) {
		
		UserDao userDao = new UserDao();
		
		System.out.println(" ENter 1 to view users 2 to view All Tickets 3 insert new Ticket  4 view ticket status");
		
		Scanner input = new Scanner(System.in);
		String selectInput = input.nextLine();
		int intInput = Integer.parseInt(selectInput);
		if (intInput == 1) {
		List<User> users = userDao.getAllUsers();
		System.out.println("| user id |   user pass   |  first name |  last name  | Email |     User Role ID");
		System.out.println("--------------------------------------------------------------------------------");
		for (User user : users) {
			
			System.out.printf("%4s    %10s    %12s     %12s    %10s   %5s   %n" ,
					user.getUser_id(), user.getUser_pass(),user.getFirst_name(),
					user.getLast_name(),user.getUser_email(),user.getUser_role_id());
			
			}
		} else if(intInput == 2) {
			
			TicketDao ticketDao = new TicketDao();
			List<Ticket> tickets = ticketDao.getTicket();
			System.out.println("| id |amount|submitted |                 | resolved  | description |  author | resolver |  r_status_id  | r_type_id");
			System.out.println("--------------------------------------------------------------------------------");
			for (Ticket ticket : tickets) {
				
				System.out.printf("%4s    %1s    %4s     %2s    %9s   %5s      %7s     %7s    %11s    %n" ,
						ticket.getId(),ticket.getAmount(),ticket.getSubmited(),ticket.getResolved(),
						ticket.getDesc(),ticket.getAuthor(),ticket.getResolver(),ticket.getR_status_id(),ticket.getR_type_id());
			
			
			}
		}
		
		else if(intInput == 3) {
			
		//	userDao.userLogin();
			
		}
		
		else if(intInput == 4) {
				
			TicketDao ticketDao = new TicketDao();
			List<Ticket> tickets = ticketDao.viewStatus();
			System.out.println("| Ticket id |amount|Ticket status | description");
			System.out.println("-----------------------------------------------");
			for (Ticket ticket : tickets) {
				
				System.out.printf("%4s    %8s    %10s     %4s    %n" ,
						ticket.getId(),ticket.getAmount(),ticket.getR_status_id(),
						ticket.getDesc());
			
		}
	}
	
	
}
}
