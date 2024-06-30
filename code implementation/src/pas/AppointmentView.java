package pas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AppointmentView {

	private JFrame frame;
	private JTextField apid;
	private JTextField adate;
	private JTextField astatus;

	/**
	 * Launch the application.
	 */
	public static void appointmentsreenw() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentView window = new AppointmentView();
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
	public AppointmentView() {
		initialize();
		Connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(201, 184, 205));
		frame.setBounds(100, 100, 1073, 714);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblViewCurrentAppointment = new JLabel("View Current Appointment Status");
		lblViewCurrentAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewCurrentAppointment.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblViewCurrentAppointment.setBounds(423, 74, 352, 44);
		frame.getContentPane().add(lblViewCurrentAppointment);
		
		JLabel lblNewLabel_1 = new JLabel("Applicant Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(187, 245, 183, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		apid = new JTextField();
		apid.setToolTipText("");
		apid.setForeground(Color.BLUE);
		apid.setColumns(10);
		apid.setBounds(392, 239, 352, 30);
		frame.getContentPane().add(apid);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String ApplicantId = apid.getText();
				
				try {
					statement = conn.prepareStatement("SELECT AppointmentDate, ApplicantStatus FROM Appointment WHERE ApplicantId=?");
					
					statement.setString(1, ApplicantId);
					
					ResultSet rs1 = statement.executeQuery();
					
					if(rs1.next()==false){
						JOptionPane.showMessageDialog(null,"Invalid Login!");
					}
					else {
						String AppointmentDate = rs1.getString(1);
						String ApplicantStatus = rs1.getString(2);
						apid.setText(ApplicantId.trim());
						adate.setText(AppointmentDate);
						astatus.setText(ApplicantStatus);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(851, 226, 121, 50);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(191, 205, 219));
		panel.setBounds(158, 358, 796, 231);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Appointment Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(117, 47, 196, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Status");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(117, 123, 99, 13);
		panel.add(lblNewLabel_3);
		
		adate = new JTextField();
		adate.setForeground(Color.BLUE);
		adate.setColumns(10);
		adate.setBounds(393, 42, 343, 28);
		panel.add(adate);
		
		astatus = new JTextField();
		astatus.setForeground(Color.BLUE);
		astatus.setColumns(10);
		astatus.setBounds(393, 118, 343, 28);
		panel.add(astatus);
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
