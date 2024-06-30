package pas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageApplicant {

	protected static final int ApplicantId = 0;
	private JFrame frame;
	private JTextField cn;
	private JTextField email;
	private JTextField gender;
	private JTextField place;
	private JTextField distict;
	private JTextField bno;
	private JTextField address;
	private JTextField nic;
	private JTextField othername;
	private JTextField surname;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageApplicant window = new ManageApplicant();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManageApplicant() {
		initialize();
		Connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(201, 184, 205));
		frame.setBounds(100, 100, 1084, 837);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("SurName");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(245, 137, 162, 56);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Other Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(245, 208, 118, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("NIC");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(245, 263, 45, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Permenent Address");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(245, 319, 118, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_9 = new JLabel("BirthCertificate Number");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBounds(245, 367, 236, 13);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Birth District");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_10.setBounds(245, 419, 180, 13);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_6 = new JLabel("Birth Place");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(245, 468, 201, 25);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Gender");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(245, 521, 94, 25);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(245, 578, 94, 18);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_4 = new JLabel("Contact number");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(245, 630, 140, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		cn = new JTextField();
		cn.setForeground(Color.BLUE);
		cn.setColumns(10);
		cn.setBounds(572, 626, 248, 25);
		frame.getContentPane().add(cn);
		
		email = new JTextField();
		email.setForeground(Color.BLUE);
		email.setColumns(10);
		email.setBounds(572, 577, 248, 25);
		frame.getContentPane().add(email);
		
		gender = new JTextField();
		gender.setForeground(Color.BLUE);
		gender.setColumns(10);
		gender.setBounds(572, 526, 248, 25);
		frame.getContentPane().add(gender);
		
		place = new JTextField();
		place.setForeground(Color.BLUE);
		place.setColumns(10);
		place.setBounds(572, 470, 248, 25);
		frame.getContentPane().add(place);
		
		distict = new JTextField();
		distict.setForeground(Color.BLUE);
		distict.setColumns(10);
		distict.setBounds(572, 415, 248, 25);
		frame.getContentPane().add(distict);
		
		bno = new JTextField();
		bno.setForeground(Color.BLUE);
		bno.setColumns(10);
		bno.setBounds(574, 363, 246, 25);
		frame.getContentPane().add(bno);
		
		address = new JTextField();
		address.setForeground(Color.BLUE);
		address.setColumns(10);
		address.setBounds(572, 307, 248, 25);
		frame.getContentPane().add(address);
		
		nic = new JTextField();
		nic.setForeground(Color.BLUE);
		nic.setColumns(10);
		nic.setBounds(572, 259, 248, 25);
		frame.getContentPane().add(nic);
		
		othername = new JTextField();
		othername.setForeground(Color.BLUE);
		othername.setColumns(10);
		othername.setBounds(572, 204, 248, 25);
		frame.getContentPane().add(othername);
		
		surname = new JTextField();
		surname.setForeground(new Color(0, 0, 255));
		surname.setColumns(10);
		surname.setBackground(SystemColor.window);
		surname.setBounds(572, 155, 248, 25);
		frame.getContentPane().add(surname);
		
		JButton aplicantintbtn = new JButton("INSERT");
		aplicantintbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Sirname = surname.getText();
				String Othername = othername.getText();
				String NIC = nic.getText();
				String PermenetAddress = address.getText();
				String BNO = bno.getText();
				int intBNO = Integer.parseInt(BNO);
				String BirthDistrict = distict.getText();
				String BirthPlace = place.getText();
				String Gender = gender.getText();
				String Email = email.getText();
				String ContactNumber = cn.getText();
				int intContactNumber = Integer.parseInt(ContactNumber);
				String ApplicantId = id.getText();
				int intApplicantId = Integer.parseInt(ApplicantId);
				
				
				
				try {
					statement = conn.prepareStatement("INSERT INTO Applicant (Sirname,Othername,NIC,PermenetAddress,BNO,BirthDistrict,BirthPlace,Gender,Email,ContactNumber) VALUES (?, ?, ?, ?, ?, ? ,?, ?, ?, ?)");
					
					statement.setString(1, Sirname);
					statement.setString(2, Othername);
					statement.setString(3, NIC);
					statement.setString(4, PermenetAddress);
					statement.setInt(5,intBNO);
					statement.setString(6, BirthDistrict);
					statement.setString(7, BirthPlace);
					statement.setString(8, Gender);
					statement.setString(9, Email);
					statement.setInt(10, intApplicantId);
				
					
					
					
					statement.executeUpdate();
					System.out.println("Successfully Inserted");
					
				
				} catch (SQLException e1) {
					System.out.println("Insertion Failed");
					e1.printStackTrace();
				}
				
				
				
			}
		});
		aplicantintbtn.setForeground(Color.BLUE);
		aplicantintbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		aplicantintbtn.setBackground(SystemColor.activeCaption);
		aplicantintbtn.setBounds(32, 137, 126, 56);
		frame.getContentPane().add(aplicantintbtn);
		
		JLabel lblNewLabel = new JLabel("APLICANT FORM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(378, 44, 335, 105);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_4_1 = new JLabel("Applicant Id");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4_1.setBounds(245, 683, 140, 13);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		id = new JTextField();
		id.setForeground(Color.BLUE);
		id.setColumns(10);
		id.setBounds(572, 682, 248, 25);
		frame.getContentPane().add(id);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				String Sirname = surname.getText();
				String Othername = othername.getText();
				String NIC = nic.getText();
				String PermenetAddress = address.getText();
				String BNO = bno.getText();
				int intBNO = 0;
				if (!BNO.isEmpty()) {
				    try {
				        intBNO = Integer.parseInt(BNO);
				    } catch (NumberFormatException e1) {
				        // Handle the exception (e.g., show an error message)
				        System.out.println("Invalid BNO value: " + BNO);
				    }
				}
				String BirthDistrict = distict.getText();
				String BirthPlace = place.getText();
				String Gender = gender.getText();
				String Email = email.getText();
				String ContactNumber = cn.getText();
				int intContactNumber = 0;
				if (!ContactNumber.isEmpty()) {
				    try {
				    	intContactNumber = Integer.parseInt(ContactNumber);
				    } catch (NumberFormatException e1) {
				        // Handle the exception (e.g., show an error message)
				        System.out.println("Invalid ContactNumber value: " + ContactNumber);
				    }
				}
				String ApplicantId = id.getText();
				int intApplicantId = 0;
				if (!ApplicantId.isEmpty()) {
				    try {
				    	intApplicantId = Integer.parseInt(ApplicantId);
				    } catch (NumberFormatException e1) {
				        // Handle the exception (e.g., show an error message)
				        System.out.println("Invalid ApplicantId value: " + ApplicantId);
				    }
				}
				
				try {
					//Delete
					String sql = "DELETE FROM Applicant WHERE ApplicantId = ?";
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setInt(1, intApplicantId);
					
					statement.executeUpdate();
					System.out.println("Successfully Deleted");
					
				}
				catch(SQLException e1) {
					System.out.println("Deletion Failed");
					System.err.println(e1);
				}
				
				
		}
		});
		btnDelete.setForeground(Color.BLUE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBackground(SystemColor.activeCaption);
		btnDelete.setBounds(32, 297, 126, 56);
		frame.getContentPane().add(btnDelete);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ApplicantId = id.getText();

				if (!ApplicantId.isEmpty()) {
				    try {
				        int intApplicantId = Integer.parseInt(ApplicantId);

				       
				        try {
				            statement = conn.prepareStatement("SELECT Sirname, Othername, NIC, PermenetAddress, BNO, BirthDistrict, BirthPlace, Gender, Email, ContactNumber FROM Applicant WHERE ApplicantId=?");

				            statement.setString(1, String.valueOf(intApplicantId));

				            ResultSet rs1 = statement.executeQuery();

				            if (rs1.next() == false) {
				                JOptionPane.showMessageDialog(null, "Data not found!");
				            } else {
				                String Sirname = rs1.getString(1);
				                String Othername = rs1.getString(2);
				                String NIC = rs1.getString(3);
				                String PermenetAddress = rs1.getString(4);
				                int BNO = rs1.getInt(5);
				                String BirthDistrict = rs1.getString(6);
				                String BirthPlace = rs1.getString(7);
				                String Gender = rs1.getString(8);
				                String Email = rs1.getString(9);
				                int ContactNumber = rs1.getInt(10);

				                surname.setText(Sirname.trim());
				                othername.setText(Othername);
				                nic.setText(NIC);
				                address.setText(PermenetAddress);
				                bno.setText(String.valueOf(BNO));
				                distict.setText(BirthDistrict);
				                place.setText(BirthPlace);
				                gender.setText(Gender);
				                email.setText(Email);
				                cn.setText(String.valueOf(ContactNumber));
				            }
				        } catch (SQLException e1) {
				            e1.printStackTrace();
				        }

				    } catch (NumberFormatException e1) {
				        JOptionPane.showMessageDialog(null, "Invalid ApplicantId value: " + ApplicantId);
				    }
				} else {
				    JOptionPane.showMessageDialog(null, "ApplicantId is empty.");
				}

				
				
				
				
				
				
				
				
				
			}
		});
		btnSearch.setForeground(Color.BLUE);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBackground(SystemColor.activeCaption);
		btnSearch.setBounds(32, 472, 126, 56);
		frame.getContentPane().add(btnSearch);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Sirname = surname.getText();
				String Othername = othername.getText();
				String NIC = nic.getText();
				String PermenetAddress = address.getText();
				String BNO = bno.getText();
				String BirthDistrict = distict.getText();
				String BirthPlace = place.getText();
				String Gender = gender.getText();
				String Email = email.getText();
				String ContactNumber = cn.getText();
				String ApplicantId = id.getText();

			
				int intBNO = BNO.isEmpty() ? 0 : Integer.parseInt(BNO);
				int intContactNumber = ContactNumber.isEmpty() ? 0 : Integer.parseInt(ContactNumber);
				int intApplicantId = ApplicantId.isEmpty() ? 0 : Integer.parseInt(ApplicantId);

				try {
				
				    String updateQuery = "UPDATE Applicant SET "
				            + (Sirname != null ? "Sirname=?, " : "")
				            + (Othername != null ? "Othername=?, " : "")
				            + (NIC != null ? "NIC=?, " : "")
				            + (PermenetAddress != null ? "PermenetAddress=?, " : "")
				            + (intBNO != 0 ? "BNO=?, " : "")
				            + (BirthDistrict != null ? "BirthDistrict=?, " : "")
				            + (BirthPlace != null ? "BirthPlace=?, " : "")
				            + (Gender != null ? "Gender=?, " : "")
				            + (Email != null ? "Email=?, " : "")
				            + (intContactNumber != 0 ? "ContactNumber=?, " : "");

				    updateQuery = updateQuery.replaceAll(", $", "");

				    updateQuery += " WHERE ApplicantId=?";

				    PreparedStatement statement = conn.prepareStatement(updateQuery);

				    int parameterIndex = 1;
				    if (Sirname != null) {
				        statement.setString(parameterIndex++, Sirname);
				    }
				    if (Othername != null) {
				        statement.setString(parameterIndex++, Othername);
				    }
				    if (NIC != null) {
				        statement.setString(parameterIndex++, NIC);
				    }
				    if (PermenetAddress != null) {
				        statement.setString(parameterIndex++, PermenetAddress);
				    }
				    if (intBNO != 0) {
				        statement.setInt(parameterIndex++, intBNO);
				    }
				    if (BirthDistrict != null) {
				        statement.setString(parameterIndex++, BirthDistrict);
				    }
				    if (BirthPlace != null) {
				        statement.setString(parameterIndex++, BirthPlace);
				    }
				    if (Gender != null) {
				        statement.setString(parameterIndex++, Gender);
				    }
				    if (Email != null) {
				        statement.setString(parameterIndex++, Email);
				    }
				    if (intContactNumber != 0) {
				        statement.setInt(parameterIndex++, intContactNumber);
				    }

				    statement.setInt(parameterIndex, intApplicantId);

				    int rowsAffected = statement.executeUpdate();

				    if (rowsAffected > 0) {
				        System.out.println(rowsAffected + " row(s) updated successfully.");
				    } else {
				        System.out.println("No rows updated. The specified condition may not match any records.");
				    }

				} catch (SQLException e1) {
				    System.out.println("Update Failed");
				    e1.printStackTrace();
				}


				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBackground(SystemColor.activeCaption);
		btnUpdate.setBounds(32, 628, 126, 56);
		frame.getContentPane().add(btnUpdate);
	}


Connection conn;
PreparedStatement statement;

public void Connect() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PAS","root","ayodhya2004"); 
	}
	catch (ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	catch (SQLException e)
	{
		e.printStackTrace();
	}



}
}


















