package pas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class AdminPolice {
    private Connection conn;
    private JFrame frame;
    private JComboBox<String> adminComboBox;
    private JTable dataTable;
    private DefaultTableModel tableModel;

    private Vector<String> applicantIds = new Vector<>();

    public static void policesrc() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminPolice window = new AdminPolice();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdminPolice() {
        initialize();
        Connect();
        loadApplicantIds();
    }

    private void loadApplicantIds() {
        try {
            String query = "SELECT ApplicantId FROM Applicant";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String applicantId = resultSet.getString("ApplicantId");
                applicantIds.add(applicantId);
            }

            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(applicantIds);
            adminComboBox.setModel(comboBoxModel);

            // Load initial data
            if (!applicantIds.isEmpty()) {
                String initialApplicantId = applicantIds.get(0);
                loadPoliceStatusForApplicantId(initialApplicantId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(201, 184, 205));
        frame.setBounds(100, 100, 856, 686);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Police Status");
        lblNewLabel.setBounds(251, 37, 335, 155);
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Applicant Id");
        lblNewLabel_1.setBounds(224, 258, 150, 30);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        frame.getContentPane().add(lblNewLabel_1);

        adminComboBox = new JComboBox<>(applicantIds);
        adminComboBox.setBounds(505, 260, 213, 30);
        frame.getContentPane().add(adminComboBox);

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{"ApplicantId", "Status"});
        dataTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(dataTable);
        scrollPane.setBounds(56, 368, 750, 155);
        frame.getContentPane().add(scrollPane);

        adminComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedApplicantId = adminComboBox.getSelectedItem().toString();
                loadPoliceStatusForApplicantId(selectedApplicantId);
            }
        });
    }

    private void loadPoliceStatusForApplicantId(String applicantId) {
        tableModel.setRowCount(0);

        try {
            String query = "SELECT * FROM policestatus WHERE ApplicantId=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, applicantId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object[] rowData = {
                        resultSet.getString("ApplicantId"),
                        resultSet.getString("Status"),
                };
                tableModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PAS", "root", "ayodhya2004");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
