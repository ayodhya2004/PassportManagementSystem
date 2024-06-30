package pas;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private String username;
	private String pwd;
	private String hostname;
	private String dbName;
	
	
	public DBConnection() {
		this.username = "root";
		this.pwd = "ayodhya2004";
		this.hostname = "localhost";
		this.dbName = "PAS";
	}
	
	public Connection dbConnect() {
		Connection conn=null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PAS","root","ayodhya2004");
			return conn;
		}
		catch(SQLException e) {
			System.err.println(e);
			return conn;
		}

	}


}
