package pas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminAppointment {

	private JFrame frame;
	private JTextField apdate;
	private JTextField apstatus;
	private JTextField appid;

	/**
	 * Launch the application.
	 */
	public static void AppointmentSrc() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAppointment window = new AdminAppointment();
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
	public AdminAppointment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1077, 752);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(201, 184, 205));
		contentPane.setBounds(0, 0, 1092, 725);
		frame.getContentPane().add(contentPane);
		
		JLabel lblNewLabel = new JLabel("Appointment Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(482, 10, 340, 125);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Appointment Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(339, 212, 151, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Appointment Status");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(339, 315, 198, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Applicant Id");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(339, 436, 151, 13);
		contentPane.add(lblNewLabel_4);
		
		apdate = new JTextField();
		apdate.setForeground(Color.BLUE);
		apdate.setColumns(10);
		apdate.setBounds(619, 205, 340, 32);
		contentPane.add(apdate);
		
		apstatus = new JTextField();
		apstatus.setForeground(Color.BLUE);
		apstatus.setColumns(10);
		apstatus.setBounds(619, 312, 334, 32);
		contentPane.add(apstatus);
		
		appid = new JTextField();
		appid.setForeground(Color.BLUE);
		appid.setColumns(10);
		appid.setBounds(619, 429, 334, 32);
		contentPane.add(appid);
		
		JButton submit = new JButton("INSERT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String AppointmentDate = apdate.getText();
				String ApplicantStatus = apstatus.getText();
				String ApplicantId = appid.getText();
				int intApplicantId = Integer.parseInt(ApplicantId);
				
				Appointment ob = new Appointment();
				ob.SubmitAppointment( AppointmentDate, ApplicantStatus, intApplicantId);
			
				
				
				
				
				
				
			}
		});
		submit.setForeground(Color.BLUE);
		submit.setFont(new Font("Tahoma", Font.BOLD, 14));
		submit.setBackground(SystemColor.activeCaption);
		submit.setBounds(42, 151, 106, 32);
		contentPane.add(submit);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String AppointmentId = appid.getText();
                int intApplicantId = Integer.parseInt(AppointmentId);

				
                Appointment ob = new Appointment();
                ob.searchAppointment(intApplicantId);
			
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(42, 361, 106, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String AppointmentId = appid.getText();
                int intApplicantId = Integer.parseInt(AppointmentId);

				
                Appointment ob = new Appointment();
                ob.CancelAppointment(intApplicantId);
			
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(42, 571, 106, 38);
		contentPane.add(btnNewButton_1);
	}
}
