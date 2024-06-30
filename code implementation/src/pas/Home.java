package pas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 1162, 810);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1057, 282);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		frame.getContentPane().setLayout(null);
		panel.setBackground(new Color(201, 184, 205));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PASSPORT AUTOMATION SYSTEM");
		lblNewLabel.setBounds(137, 77, 830, 129);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		panel.add(lblNewLabel);
		
		JButton aplbtn = new JButton("APPLICATION");
		aplbtn.setBounds(62, 346, 222, 97);
		aplbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ApplicantForm nw = new ApplicantForm();
				nw.src();
				
				
				
				
				
				
			}
		});
		aplbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		aplbtn.setForeground(new Color(0, 0, 255));
		frame.getContentPane().add(aplbtn);
		
		JButton sdminbtn = new JButton("ADMINISTRATOR");
		sdminbtn.setBounds(778, 346, 222, 97);
		sdminbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLoginPage nw = new AdminLoginPage();
				nw.admin();
				
				
				
			}
		});
		sdminbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		sdminbtn.setForeground(new Color(0, 0, 255));
		frame.getContentPane().add(sdminbtn);
		
		JButton astatusbtn = new JButton("APPOINTMENT STATUS");
		astatusbtn.setBounds(398, 486, 300, 108);
		astatusbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AppointmentView nw = new AppointmentView();
				nw.appointmentsreenw();
				
				
				
				
				
				
			}
		});
		astatusbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		astatusbtn.setForeground(new Color(0, 0, 255));
		frame.getContentPane().add(astatusbtn);
		
		JButton pstatusbtn = new JButton("PASSPORT STATUS");
		pstatusbtn.setBounds(778, 636, 222, 97);
		pstatusbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassportForm nw =  new PassportForm();
				nw.passportsrc();
				
				
				
				
				
				
				
				
			}
		});
		pstatusbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		pstatusbtn.setForeground(new Color(0, 0, 255));
		frame.getContentPane().add(pstatusbtn);
		
		JButton btnPolice = new JButton("POLICE");
		btnPolice.setBounds(62, 636, 222, 97);
		btnPolice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Police nw = new Police();
				nw.policeverification();
				
				
			}
		});
		btnPolice.setForeground(Color.BLUE);
		btnPolice.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(btnPolice);
	}
}
