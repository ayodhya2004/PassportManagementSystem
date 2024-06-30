package pas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Passport {
	
	private String IssueDate;
	private String PassportStatus;
	private int ApplicantId;

	
	public Passport() {
		this.IssueDate = null;
		this.PassportStatus = null;
		this.ApplicantId = 0;
}
	
public Passport(String IssueDate,String PassportStatus,int ApplicantId) {
		
		this.IssueDate = IssueDate;
		this.PassportStatus = PassportStatus;
		this.ApplicantId = ApplicantId;
}

public void InsertPassport(String IssueDate,String PassportStatus,int ApplicantId) {
	DBConnection ob = new DBConnection();
	Connection conn = ob.dbConnect();
	try {
		//insert
		String sql = "INSERT INTO Passport (IssueDate,PassportStatus,ApplicantId) VALUES (?, ?, ?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setString(1, IssueDate);	
		statement.setString(2, PassportStatus);
		statement.setInt(3, ApplicantId);
		statement.executeUpdate();
		System.out.println("Sent Successfully");
		
	}
	catch(SQLException e) {
		System.out.println(" Failed");
		System.err.println(e);
	}
}
}