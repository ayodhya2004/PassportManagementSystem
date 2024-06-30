package pas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Appointment {

	private String AppointmentDate;
	private String ApplicantStatus;
	private int ApplicantId;
	
	public Appointment(){
		this.AppointmentDate = AppointmentDate;
		this.ApplicantStatus = ApplicantStatus;
		this.ApplicantId = ApplicantId;
		
	}
	
	public Appointment(String AppointmentDate,String ApplicantStatus,int ApplicantId) {
		
		this.AppointmentDate = AppointmentDate;
		this.ApplicantStatus = ApplicantStatus;
		this.ApplicantId = ApplicantId;
	
	}
	public void SubmitAppointment(String AppointmentDate,String ApplicantStatus,int ApplicantId) {
		DBConnection ob = new DBConnection();
		Connection conn = ob.dbConnect();
		try {
			//insert
			String sql = "INSERT INTO Appointment (AppointmentDate,ApplicantStatus,ApplicantId) VALUES (?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, AppointmentDate);
			statement.setString(2, ApplicantStatus);
			statement.setInt(3, ApplicantId);	
			
			statement.executeUpdate();
			System.out.println("Successfully Submitted");
			
		}
		catch(SQLException e) {
			System.out.println("Submission Failed");
			System.err.println(e);
		}
	}
	
	
	public void searchAppointment(int ApplicantId) {
		DBConnection ob = new DBConnection();
		Connection conn = ob.dbConnect();
		
		try {
			String sql = "SELECT * FROM Appointment WHERE ApplicantId = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, ApplicantId);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String AppointmentDate = rs.getString("AppointmentDate");
				String ApplicantStatus = rs.getString("ApplicantStatus");
				String ApplicantId1 = rs.getString("ApplicantId");
				
				System.out.println(" AppointmentDate: " + AppointmentDate + ", ApplicantStatus: " + ApplicantStatus + ", ApplicantId: " + ApplicantId1);
			}
		}
		catch(SQLException e) {
			System.out.println("Search Failed");
			System.err.println(e);}
		}
	
	public void CancelAppointment(int ApplicantId1) {
	    DBConnection ob = new DBConnection();
	    Connection conn = ob.dbConnect();
	    try {
	        // Delete
	        String sql = "DELETE FROM Appointment WHERE ApplicantId = ?";
	        PreparedStatement statement = conn.prepareStatement(sql);

	        statement.setInt(1, ApplicantId1);  

	        statement.executeUpdate();
	        System.out.println("Successfully Deleted");

	    } catch (SQLException e) {
	        System.out.println("Deletion Failed");
	        System.err.println(e);
	    }
	}


	
		
	}
			
		
	
