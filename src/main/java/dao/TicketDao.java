package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Ticket;
import model.User;
import util.ConnectionUtil;

public class TicketDao {

	
	//This will return all the data of the users.
		public List<Ticket> getTicket() {
			// complete this method to return a list type 
			try(Connection conn = ConnectionUtil.getConnection() ) {
				
				String sql = "select * from  reimbursement";
				PreparedStatement  ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				List <Ticket> tickets = new ArrayList();
				while (rs.next()) {
					Ticket ticket = getTicket(rs);
					tickets.add(ticket);
				}
				return tickets;
				
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
							
			}
			
	} 
		
		
		
		public Ticket checkTicket(Ticket ticket) {
			// complete this method to return a list type 
			try(Connection conn = ConnectionUtil.getConnection() ) {
				
				String sql = "select * from  reimbursement";
				PreparedStatement  ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
								
				while (rs.next()) {
					//int amount = rs.getInt("amount");
					if (rs.getInt("amount") == ticket.getAmount()) {
						
						System.out.println("connection established successfully");
						return ticket;
					}else{
						return ticket;
					}
				}
				return ticket;
				
			}catch(SQLException e) {
				e.printStackTrace();
				return ticket;
							
			}
			
			
	} 

		
	private Ticket getTicket(ResultSet rs)throws SQLException{
		 
		 int id = rs.getInt("r_id");
		 int amount = rs.getInt("amount");
		 Timestamp submitted = rs.getTimestamp("submitted");
		 Timestamp resolved = rs.getTimestamp("resolved");
		 String description = rs.getString("description");
		 int author = rs.getInt("author");
		 int resolver = rs.getInt("resolver");
		 int r_status_id = rs.getInt("r_status_id");
		 int r_type_id = rs.getInt("r_type_id");
	 
		 Ticket ticket = new Ticket(id,amount,submitted,resolved,description,author,resolver,r_status_id,r_type_id);
		 return ticket;

	}
		
	//this will take the user input as UserID as a parameter and return the request
	//ticket info
	 public List<Ticket> viewStatus(/*int UserInputId*/){
		 
		 String viewStatusQuerey = "select * from reimbursement where reimbursement.author = ?;";
		//int userInput = UserInputId;
			try(Connection conn = ConnectionUtil.getConnection() ) {
							
				PreparedStatement  ps = conn.prepareStatement(viewStatusQuerey);
				//int userInput = should be instead of ?, in this example number 2
				ps.setInt(1, 2);
				ResultSet rs = ps.executeQuery();
				List <Ticket> tickets = new ArrayList();
				while (rs.next()) {
					Ticket ticket = getTicket(rs);
					tickets.add(ticket);
				}
				return tickets;
				
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
							
			}
		 
		 
	 	}
	 //the following ticket should brought from the servlet coming from ObjectMapper 
	 // allready deserialized from the om
	 
	 public void newTicket(Ticket ticket) {
		 
		 String insertQuerey = "insert into reimbursement(r_id,amount,description,author,r_status_id,r_type_id) \r\n" + 
		 		"			values(?,?,?,?,?,?);";
		 	    
		 		// her geting the userID
		 	//	int userInput = UserInputId;
				try(Connection conn = ConnectionUtil.getConnection() ) {
								
					PreparedStatement  ps = conn.prepareStatement(insertQuerey);
				
					ps.setInt(1, 1003);
					ps.setInt(2, 60);
					ps.setString(3,"Travel bill");
					ps.setInt(4,2);
					ps.setInt(5,0);
					ps.setInt(6,40);
					ps.executeQuery();
					
					/*
					ps.setInt(1, ticket.getId());
					ps.setInt(2, ticket.getAmount());
					ps.setString(3,ticket.getDesc());
					ps.setInt(4,ticket.getAuthor() );
					ps.setInt(5,ticket.getR_status_id());
					ps.setInt(6,ticket.getR_type_id());
					ps.executeQuery();
					
				*/
					
				}catch(SQLException e) {
					e.printStackTrace();
					
								
				}
			 
		 
		 
		 
	 }
	 
	 // to create a ticket
	 //amount and discription and type
	 // fro time, we have to put the currnet time stamp using java.
	 //public Ticket
	 //updating the time stamp :
	 /*
	  * 
	  * 1- inserting, it will be updated autamtically.
	  * 
	  * updating, sent thogh the querey , not using the ?.
	  * 
	  * 
	  */

	
}
