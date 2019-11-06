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

	// This will return all the data of the users.
	public List<Ticket> getTicket() {
		// complete this method to return a list type
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "select * from  reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Ticket> tickets = new ArrayList();
			while (rs.next()) {
				Ticket ticket = getTicket(rs);
				tickets.add(ticket);
			}
			return tickets;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}

	}

	public List<Ticket> checkTicket(Ticket ticket) {
		// complete this method to return a list type
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "select * from reimbursement where author = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ticket.getAuthor());
			ResultSet rs = ps.executeQuery();
			List<Ticket> tickets = new ArrayList();
			while (rs.next()) {
				Ticket newTicket = getTicket(rs);
				tickets.add(newTicket);
				
			}
			return tickets;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}

	}

	private Ticket getTicket(ResultSet rs) throws SQLException {

		int id = rs.getInt("r_id");
		int amount = rs.getInt("amount");
		Timestamp submitted = rs.getTimestamp("submitted");
		Timestamp resolved = rs.getTimestamp("resolved");
		String description = rs.getString("description");
		int author = rs.getInt("author");
		int resolver = rs.getInt("resolver");
		int r_status_id = rs.getInt("r_status_id");
		int r_type_id = rs.getInt("r_type_id");

		Ticket ticket = new Ticket(id, amount, submitted, resolved, description, author, resolver, r_status_id,
				r_type_id);
		return ticket;

	}

	// this will take the user input as UserID as a parameter and return the request
	// ticket info
	public List<Ticket> viewStatus(/* int UserInputId */) {

		String viewStatusQuerey = "select * from reimbursement where reimbursement.author = ?;";
		// int userInput = UserInputId;
		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(viewStatusQuerey);
			// int userInput = should be instead of ?, in this example number 2
			ps.setInt(1, 2);
			ResultSet rs = ps.executeQuery();
			List<Ticket> tickets = new ArrayList();
			while (rs.next()) {
				Ticket ticket = getTicket(rs);
				tickets.add(ticket);
			}
			return tickets;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}

	}

	// the following ticket should brought from the servlet coming from ObjectMapper
	// allready deserialized from the om

	public Ticket newTicket(Ticket ticket) {

		String insertQuerey = "insert into reimbursement(amount,description,author,r_type_id) values(?,?,?,?) returning *;";

		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(insertQuerey);
			
			ps.setInt(1, ticket.getAmount());
			ps.setString(2, ticket.getDesc());
			ps.setInt(3, ticket.getAuthor());
			ps.setInt(4, ticket.getR_type_id());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Ticket newTicket = getTicket(rs);
				return newTicket;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;

	}

		
	public Ticket approveDenyTicket(Ticket ticket) {

		String insertQuerey = "update reimbursement set resolved = current_timestamp,resolver= ?, r_status_id = ?  where r_id = ? returning *;";

		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(insertQuerey);
			
			ps.setInt(1, ticket.getResolver());
			ps.setInt(2, ticket.getR_status_id());
			ps.setInt(3, ticket.getId());
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Ticket newTicket = getTicket(rs);
				return newTicket;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;

	}
	
}
