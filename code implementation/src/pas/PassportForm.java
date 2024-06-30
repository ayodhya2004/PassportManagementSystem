package pas;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PassportForm {

	private JFrame frame;
	private JTextField id;
	private JTextField issuedate;
	private JTextField psstatus;

	/**
	 * Launch the application.
	 */
	public static void passportsrc() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassportForm window = new PassportForm();
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
	public PassportForm() {
		initialize();
		Connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 938, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Current Status");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(392, 49, 217, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(71, 287, 796, 231);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Issue Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(117, 47, 116, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Status");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(117, 123, 99, 13);
		panel.add(lblNewLabel_3);
		
		issuedate = new JTextField();
		issuedate.setForeground(new Color(0, 0, 255));
		issuedate.setBounds(393, 42, 343, 28);
		panel.add(issuedate);
		issuedate.setColumns(10);
		
		psstatus = new JTextField();
		psstatus.setForeground(new Color(0, 0, 255));
		psstatus.setColumns(10);
		psstatus.setBounds(393, 118, 343, 28);
		panel.add(psstatus);
		
		JLabel lblNewLabel_1 = new JLabel("Applicant Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(102, 204, 183, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		id = new JTextField();
		id.setForeground(new Color(0, 0, 255));
		id.setToolTipText("");
		id.setBounds(358, 198, 352, 30);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ApplicantId = id.getText();
				
				try {
					statement = conn.prepareStatement("SELECT IssueDate, PassportStatus FROM Passport WHERE ApplicantId=?");
					
					statement.setString(1, ApplicantId);
					
					ResultSet rs1 = statement.executeQuery();
					
					if(rs1.next()==false){
						JOptionPane.showMessageDialog(null,"Invalid Login!");
					}
					else {
						String IssueDate = rs1.getString(1);
						String PassportStatus = rs1.getString(2);
						issuedate.setText(IssueDate.trim());
						psstatus.setText(PassportStatus);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(763, 185, 121, 50);
		frame.getContentPane().add(btnNewButton);
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





















