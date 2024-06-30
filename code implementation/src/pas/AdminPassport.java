package pas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPassport {

	private JFrame frame;
	private JTextField isdate;
	private JTextField status;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void PassportSrc() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPassport window = new AdminPassport();
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
	public AdminPassport() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Passport Application");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(364, 33, 380, 39);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Issue Date");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(286, 189, 189, 13);
		frame.getContentPane().add(lblNewLabel);
		
		isdate = new JTextField();
		isdate.setForeground(Color.BLUE);
		isdate.setColumns(10);
		isdate.setBounds(644, 185, 302, 26);
		frame.getContentPane().add(isdate);
		
		JLabel lblNewLabel_1 = new JLabel("Passport Status");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(286, 261, 189, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		status = new JTextField();
		status.setForeground(Color.BLUE);
		status.setColumns(10);
		status.setBounds(644, 257, 302, 26);
		frame.getContentPane().add(status);
		
		JLabel lblNewLabel_2 = new JLabel("Aplicant Id");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(286, 348, 176, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		id = new JTextField();
		id.setForeground(Color.BLUE);
		id.setColumns(10);
		id.setBounds(644, 335, 302, 26);
		frame.getContentPane().add(id);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String IssueDate = isdate.getText();
				String PassportStatus = status.getText();
				String ApplicantId = id.getText();
				int intApplicantId = Integer.parseInt(ApplicantId);
				
				Passport ob = new Passport(IssueDate,PassportStatus,intApplicantId);
				ob.InsertPassport(IssueDate, PassportStatus, intApplicantId);
				
				
				
				
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(868, 456, 118, 39);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 1074, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
