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
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLoginPage {

	private JFrame frame;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void admin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginPage window = new AdminLoginPage();
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
	public AdminLoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(201, 184, 205));
		frame.setBounds(100, 100, 544, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("LOG IN");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(178, 21, 173, 58);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("USER NAME :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(45, 136, 146, 28);
		frame.getContentPane().add(lblNewLabel);
		
		username = new JTextField();
		username.setForeground(Color.BLUE);
		username.setColumns(10);
		username.setBounds(233, 139, 248, 28);
		frame.getContentPane().add(username);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(45, 185, 106, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		password = new JTextField();
		password.setForeground(Color.BLUE);
		password.setColumns(10);
		password.setBounds(233, 192, 248, 28);
		frame.getContentPane().add(password);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminHomePage nw = new AdminHomePage();
				nw.newscreen();
				
				
				
				String uname = username.getText();
				String pass = password.getText();
				
				if(uname.equals("admin")& pass.equals("1234")) {
					
					AdminHomePage hframe = new AdminHomePage();
					hframe.setVisible(true);
					
				}else {
					
					AdminLoginPage lframe =  new AdminLoginPage();
					JOptionPane.showInputDialog(lframe, "Invalid Login");
				}
				
				
				
				
				
				
			}
		});
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(186, 69, 92));
		btnNewButton.setBounds(205, 300, 146, 51);
		frame.getContentPane().add(btnNewButton);
	}
}
