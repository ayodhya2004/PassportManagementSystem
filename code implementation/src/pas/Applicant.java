package pas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Applicant {
	
	private String Sirname;
	private String Othername;
	private String NIC;
	private String PermenetAddress;
	private int BNO;
	private String BirthDistrict;
	private String BirthPlace; 
	private String Gender; 
	private String Email; 
	private int ContactNumber; 
	
	
	
	
	public Applicant() {
		this.Sirname = null;
		this.Othername = null;
		this.NIC = null;
		this.PermenetAddress = null;
		this.BNO = 0;
		this.BirthDistrict = null;
		this.BirthPlace = null;
		this.Gender = null;
		this.Email = null;
		this.ContactNumber = 0;
		
	}
	
	public Applicant(String Sirname,String Othername,String NIC,String PermenetAddress,int BNO,String BirthDistrict,String BirthPlace,String Gender,String Email,int ContactNumber) {
		
		this.Sirname = Sirname;
		this.Othername = Othername;
		this.NIC = NIC;
		this.PermenetAddress = PermenetAddress;
		this.BNO = BNO;
		this.BirthDistrict = BirthDistrict;
		this.BirthPlace = BirthPlace;
		this.Gender = Gender;
		this.Email = Email;
		this.ContactNumber = ContactNumber;
		
		}
	
	public void SubmitApplicant(String Sirname,String Othername,String NIC,String PermenetAddress,int BNO,String BirthDistrict,String BirthPlace,String Gender,String Email,int ContactNumber) {
		DBConnection ob = new DBConnection();
		Connection conn = ob.dbConnect();
		try {
			//insert
			String sql = "INSERT INTO Applicant (Sirname,Othername,NIC,PermenetAddress,BNO,BirthDistrict,BirthPlace,Gender,Email,ContactNumber) VALUES (?, ?, ?, ?, ?, ? ,?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, Sirname);	
			statement.setString(2, Othername);
			statement.setString(3, NIC);
			statement.setString(4, PermenetAddress);	
			statement.setInt(5, BNO);	
			statement.setString(6, BirthDistrict);	
			statement.setString(7, BirthPlace);
			statement.setString(8, Gender);
			statement.setString(9, Email);
			statement.setInt(10, ContactNumber);
			
			
			
			
			statement.executeUpdate();
			System.out.println("Successfully Submitted");
			
		}
		catch(SQLException e) {
			System.out.println("Submission Failed");
			System.err.println(e);
		}
	}
		
	
	
	
	
	
	
	
	
	
	
	
}