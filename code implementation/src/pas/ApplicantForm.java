package pas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JCheckBox;

public class ApplicantForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField surname;
	private JTextField nic;
	private JTextField address;
	private JTextField place;
	private JTextField email;
	private JTextField cn;
	private JTextField othername;
	private JTextField bno;
	private JTextField birthdis;
	private JTextField gender;

	/**
	 * Launch the application.
	 */
	public static void src() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicantForm frame = new ApplicantForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ApplicantForm() {
		setTitle("Aplicant Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1106, 790);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(201, 184, 205));
		contentPane.setToolTipText("Applicant Frame");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("APLICANT FORM");
		lblNewLabel.setBounds(435, 10, 335, 105);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("SurName");
		lblNewLabel_2.setBounds(302, 103, 162, 56);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_2);
		
		surname = new JTextField();
		surname.setBackground(SystemColor.window);
		surname.setForeground(new Color(0, 0, 255));
		surname.setBounds(629, 121, 248, 25);
		contentPane.add(surname);
		surname.setColumns(10);
		
		JButton aplicantintbtn = new JButton("SUBMIT");
		aplicantintbtn.setBackground(SystemColor.activeCaption);
		aplicantintbtn.setForeground(new Color(0, 0, 255));
		aplicantintbtn.setBounds(933, 596, 126, 56);
		aplicantintbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Sirname = surname.getText();
				String otherName = othername.getText();
				String NIC = nic.getText();
				String PermenetAddress = address.getText();
				String BNO = bno.getText();
				int intBNO = Integer.parseInt(BNO);
				String BirthDistrict = birthdis.getText();
				String BirthPlace = place.getText();
				String Gender = gender.getText();
				String Email = email.getText();
				String ContactNumber = cn.getText();
				int intContactNumber = Integer.parseInt(ContactNumber);
				
				Applicant ob = new Applicant(Sirname,otherName,NIC,PermenetAddress,intBNO,BirthDistrict,BirthPlace,Gender,Email,intContactNumber);
				ob.SubmitApplicant(Sirname, otherName, NIC, PermenetAddress, intBNO, BirthDistrict, BirthPlace, Gender, Email, intContactNumber);
				
				
			}
		});
		aplicantintbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(aplicantintbtn);
		
		JLabel lblNewLabel_3 = new JLabel("Permenent Address");
		lblNewLabel_3.setBounds(302, 285, 118, 13);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contact number");
		lblNewLabel_4.setBounds(302, 596, 140, 13);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_4);
		
		nic = new JTextField();
		nic.setForeground(new Color(0, 0, 255));
		nic.setBounds(629, 225, 248, 25);
		contentPane.add(nic);
		nic.setColumns(10);
		
		address = new JTextField();
		address.setForeground(new Color(0, 0, 255));
		address.setBounds(629, 273, 248, 25);
		contentPane.add(address);
		address.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("NIC");
		lblNewLabel_5.setBounds(302, 229, 45, 13);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Birth Place");
		lblNewLabel_6.setBounds(302, 434, 201, 25);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setBounds(302, 544, 94, 18);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_7);
		
		place = new JTextField();
		place.setForeground(new Color(0, 0, 255));
		place.setBounds(629, 436, 248, 25);
		contentPane.add(place);
		place.setColumns(10);
		
		email = new JTextField();
		email.setForeground(new Color(0, 0, 255));
		email.setBounds(629, 543, 248, 25);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Gender");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(302, 487, 94, 25);
		contentPane.add(lblNewLabel_8);
		
		cn = new JTextField();
		cn.setForeground(new Color(0, 0, 255));
		cn.setBounds(629, 592, 248, 25);
		contentPane.add(cn);
		cn.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Other Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(302, 174, 118, 13);
		contentPane.add(lblNewLabel_1);
		
		othername = new JTextField();
		othername.setForeground(new Color(0, 0, 255));
		othername.setBounds(629, 170, 248, 25);
		contentPane.add(othername);
		othername.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("BirthCertificate Number");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBounds(302, 333, 236, 13);
		contentPane.add(lblNewLabel_9);
		
		bno = new JTextField();
		bno.setForeground(new Color(0, 0, 255));
		bno.setBounds(631, 329, 246, 25);
		contentPane.add(bno);
		bno.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Birth District");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_10.setBounds(302, 385, 180, 13);
		contentPane.add(lblNewLabel_10);
		
		birthdis = new JTextField();
		birthdis.setForeground(new Color(0, 0, 255));
		birthdis.setBounds(629, 381, 248, 25);
		contentPane.add(birthdis);
		birthdis.setColumns(10);
		
		gender = new JTextField();
		gender.setForeground(new Color(0, 0, 255));
		gender.setBounds(629, 492, 248, 25);
		contentPane.add(gender);
		gender.setColumns(10);
		
		JButton btnUploadDocuments = new JButton("UPLOAD DOCUMENTS");
		btnUploadDocuments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ImageUploadForm nw = new ImageUploadForm();
				nw.imagesrc();
				
				
				
				
			}
		});
		btnUploadDocuments.setForeground(Color.BLUE);
		btnUploadDocuments.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUploadDocuments.setBackground(SystemColor.activeCaption);
		btnUploadDocuments.setBounds(802, 673, 257, 56);
		contentPane.add(btnUploadDocuments);
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