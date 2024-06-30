package pas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminHomePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void newscreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHomePage window = new AdminHomePage();
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
	public AdminHomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 606, 379);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBounds(0, 0, 805, 555);
		frame.getContentPane().add(contentPane);
		
		JButton btnNewButton = new JButton("APPLICANT");
		btnNewButton.setBounds(31, 45, 142, 57);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageApplicant nw = new ManageApplicant();
				nw.NewScreen();
				
				
				
				
				
				
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnNewButton);
		
		JButton btnPassport = new JButton("PASSPORT");
		btnPassport.setBounds(31, 220, 142, 57);
		btnPassport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminPassport nw = new AdminPassport();
				nw.PassportSrc();
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnPassport.setForeground(Color.BLUE);
		btnPassport.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnPassport);
		
		JButton btnAppointment = new JButton("APPOINTMENT");
		btnAppointment.setBounds(396, 45, 142, 57);
		btnAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminAppointment nw = new AdminAppointment();
				nw.AppointmentSrc();
				
				
				
				
				
				
				
				
				
			}
		});
		btnAppointment.setForeground(Color.BLUE);
		btnAppointment.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnAppointment);
		
		JButton btnPolice = new JButton("POLICE");
		btnPolice.setBounds(396, 220, 142, 57);
		btnPolice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPolice nw = new AdminPolice();
				nw.policesrc();
				
				
				
				
				
				
				
			}
		});
		btnPolice.setForeground(Color.BLUE);
		btnPolice.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnPolice);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
