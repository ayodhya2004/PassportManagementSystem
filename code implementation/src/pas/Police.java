package pas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Police {
	private Connection conn;
    private JFrame frame;
    private JComboBox<String> jcomboid;
    private JTable dataTable;
    private DefaultTableModel tableModel;

    private Vector<String> applicantIds = new Vector<>();

    public static void policeverification() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Police window = new Police();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Police() {
        initialize();
        Connect();
        loadApplicantIds();
    }

    	private void loadApplicantIds() {
    	    try {
    	        String query = "SELECT ApplicantId FROM Applicant"; // Corrected table name
    	        PreparedStatement statement = conn.prepareStatement(query);
    	        ResultSet resultSet = statement.executeQuery();

    	        while (resultSet.next()) {
    	            String applicantId = resultSet.getString("ApplicantId");
    	            applicantIds.add(applicantId);
    	        }

    	        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(applicantIds);
    	        jcomboid.setModel(comboBoxModel);

    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	}

        // TODO Auto-generated method stub
    


    	    private void initialize() {
    	        frame = new JFrame();
    	        frame.getContentPane().setBackground(new Color(201, 184, 205));
    	        frame.setBounds(100, 100, 856, 686);
    	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	        frame.getContentPane().setLayout(null);

    	        JLabel lblNewLabel = new JLabel("POLICE");
    	        lblNewLabel.setBounds(264, 0, 335, 155);
    	        lblNewLabel.setForeground(new Color(0, 0, 0));
    	        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
    	        frame.getContentPane().add(lblNewLabel);

    	        JLabel lblNewLabel_1 = new JLabel("Applicant Id");
    	        lblNewLabel_1.setBounds(167, 218, 209, 48);
    	        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
    	        frame.getContentPane().add(lblNewLabel_1);

    	        jcomboid = new JComboBox<>(applicantIds);
    	        jcomboid.setBounds(415, 231, 242, 30);
    	        frame.getContentPane().add(jcomboid);
    	        JButton verifyButton = new JButton("VERIFY");
    	        verifyButton.addActionListener(new ActionListener() {
    	            @Override
    	            public void actionPerformed(ActionEvent e) {
   
    	                verifyApplicant();
    	            }
    	        });
    	        verifyButton.setBounds(82, 529, 157, 48);
    	        verifyButton.setFont(new Font("Tahoma", Font.BOLD, 16));
    	        verifyButton.setForeground(new Color(0, 0, 255));
    	        frame.getContentPane().add(verifyButton);

    	        
    	        JButton cancelButton = new JButton("CANCEL");
    	        cancelButton.setBounds(573, 529, 157, 48);
    	        cancelButton.setForeground(Color.BLUE);
    	        cancelButton.setFont(new Font("Tahoma", Font.BOLD, 16));
    	        frame.getContentPane().add(cancelButton);
    	        
    	        cancelButton.addActionListener(new ActionListener() {
    	            @Override
    	            public void actionPerformed(ActionEvent e) {
    	                cancelVerification();
    	            }
    	        });

    	        if (jcomboid != null) {
    	            jcomboid.addActionListener(new ActionListener() {
    	                @Override
    	                public void actionPerformed(ActionEvent e) {
    	                    String selectedApplicantId = jcomboid.getSelectedItem().toString();
    	                    loadDataForApplicantId(selectedApplicantId);
    	                }
    	            });

    	            tableModel = new DefaultTableModel();
    	            tableModel.setColumnIdentifiers(new Object[]{"Sirname", "Othername", "NIC", "PermenetAddress", "BNO", "BirthDistrict", "Gender", "Email"});

    	            dataTable = new JTable(tableModel);
    	            JScrollPane scrollPane = new JScrollPane(dataTable);
    	            scrollPane.setBounds(50, 300, 750, 100);
    	            frame.getContentPane().add(scrollPane);
    	        }
    	    }

    	    private void verifyApplicant() {
    	        String selectedApplicantId = jcomboid.getSelectedItem().toString();

    	        if (selectedApplicantId != null && !selectedApplicantId.isEmpty()) {
    	            try {
    	                if (isAlreadyVerified(selectedApplicantId)) {
    	                    JOptionPane.showMessageDialog(frame, "Applicant is already verified");
    	                } else {
    	                    String updateQuery = "INSERT INTO policestatus (App licantId, status) VALUES (?, 'verified')";
    	                    PreparedStatement updateStatement = conn.prepareStatement(updateQuery);
    	                    updateStatement.setString(1, selectedApplicantId);

    	                    int rowsAffected = updateStatement.executeUpdate();

    	                    if (rowsAffected > 0) {
    	                        JOptionPane.showMessageDialog(frame, "Applicant Verified");
    	                    } else {
    	                        JOptionPane.showMessageDialog(frame, "Verification failed");
    	                    }
    	                }
    	            } catch (SQLException ex) {
    	                ex.printStackTrace();
    	                JOptionPane.showMessageDialog(frame, "Error during verification: " + ex.getMessage());
    	            }
    	        } else {
    	            JOptionPane.showMessageDialog(frame, "Please select an applicant ID");
    	        }
    	    }


    	    private boolean isAlreadyVerified(String selectedApplicantId) {
				// TODO Auto-generated method stub
				return false;
			}

			private void cancelVerification() {
    	    	String selectedApplicantId = jcomboid.getSelectedItem().toString();
    	    	
    	    	if(selectedApplicantId != null && !selectedApplicantId.isEmpty()) {
    	    		
    	    		try {
    	    			String updateQuery = "INSERT INTO policestatus (ApplicantId,status)VALUES(?,'Canceled')";
    	    			PreparedStatement updateStatement = conn.prepareStatement(updateQuery);
    	    			updateStatement.setString(1, selectedApplicantId);
    	    			
    	    			int rowsAffected = updateStatement.executeUpdate();
    	    			
    	    			if(rowsAffected > 0) {
    	    				JOptionPane.showMessageDialog(frame, "Verification Cancelled");
    	    			}else {
    	    				JOptionPane.showMessageDialog(frame, "Cancellation Failed");

    	    			}
    	    		}catch(SQLException ex) {
    	    			ex.printStackTrace();
	    				JOptionPane.showMessageDialog(frame, "Error during cancellation");

    	    		}
    	    	}else {
    				JOptionPane.showMessageDialog(frame, "Please select an applicant ID");

    	    		
    	    	}
    	    }
    	    private void loadDataForApplicantId(String ApplicantId) {
    	        tableModel.setRowCount(0);

    	        try {
    	            String query = "SELECT * FROM Applicant WHERE ApplicantId=?";
    				PreparedStatement statement = conn.prepareStatement(query);
    	            statement.setString(1, ApplicantId);

    	            ResultSet resultSet = statement.executeQuery();

    	            while (resultSet.next()) {
    	                Object[] rowData = {
    	                        resultSet.getString("Sirname"),
    	                        resultSet.getString("Othername"),
    	                        resultSet.getString("NIC"),
    	                        resultSet.getString("PermenetAddress"),
    	                        resultSet.getString("BNO"),
    	                        resultSet.getString("BirthDistrict"),
    	                        resultSet.getString("Gender"),
    	                        resultSet.getString("Email")
    	                };
    	                tableModel.addRow(rowData);
    	            }
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }
    	    

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PAS", "root", "ayodhya2004");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        
        }
    
    }
}
    	

    
