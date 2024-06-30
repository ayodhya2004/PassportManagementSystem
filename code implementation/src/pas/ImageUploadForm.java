package pas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageUploadForm extends JFrame {
    private JLabel nicLabel;
    private JLabel passportLabel;
    private JLabel birthCertificateLabel;
    private JButton submitButton;
    private JButton btnCancel;
    private JTextField applicantIdTextField;
    

    private Connection conn;

    public void imagesrc() {
    }
    
    public ImageUploadForm() {
        setTitle("Image Upload Form");
        setSize(800, 763);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nicLabel = new JLabel("NIC");
        passportLabel = new JLabel("Passport Photo");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(201, 184, 205));

        JPanel imagePanel = new JPanel(new GridLayout(1, 3));
        birthCertificateLabel = new JLabel("Birth Certificate");
        imagePanel.add(birthCertificateLabel);
        imagePanel.add(nicLabel);
        imagePanel.add(passportLabel);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        mainPanel.add(buttonPanel);
        buttonPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Applicant Id");
        lblNewLabel.setBounds(114, 142, 100, 25);
        buttonPanel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        applicantIdTextField = new JTextField();
        applicantIdTextField.setBounds(259, 144, 100, 25);
        buttonPanel.add(applicantIdTextField);

        submitButton = new JButton("SUBMIT");
        submitButton.setBounds(412, 144, 100, 25);
        buttonPanel.add(submitButton);

        submitButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        submitButton.setForeground(new Color(0, 0, 255));

        JLabel lblDocumentUploadForm = new JLabel("DOCUMENT UPLOAD FORM");
        lblDocumentUploadForm.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblDocumentUploadForm.setBounds(259, 47, 327, 25);
        buttonPanel.add(lblDocumentUploadForm);

        btnCancel = new JButton("Cancel");
        btnCancel.setForeground(Color.BLUE);
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCancel.setBounds(593, 146, 100, 25);
        buttonPanel.add(btnCancel);

        JPanel applicantIdPanel = new JPanel();
        applicantIdPanel.setBackground(new Color(201, 184, 205));
        applicantIdPanel.setLayout(null);

        mainPanel.add(applicantIdPanel);

        JButton bc = new JButton("Birth Certificate");
        bc.setForeground(Color.BLUE);
        bc.setFont(new Font("Tahoma", Font.BOLD, 14));
        bc.setBounds(35, 62, 166, 25);
        applicantIdPanel.add(bc);

        JButton nic = new JButton("NIC");
        nic.setForeground(Color.BLUE);
        nic.setFont(new Font("Tahoma", Font.BOLD, 14));
        nic.setBounds(280, 66, 100, 25);
        applicantIdPanel.add(nic);

        JButton pass = new JButton("Passport");
        pass.setForeground(Color.BLUE);
        pass.setFont(new Font("Tahoma", Font.BOLD, 14));
        pass.setBounds(556, 66, 100, 25);
        applicantIdPanel.add(pass);

        mainPanel.add(imagePanel);

        getContentPane().add(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);

        Connect();

        // Add action listeners
        bc.addActionListener(e -> uploadImage("Birth Certificate", birthCertificateLabel));
        nic.addActionListener(e -> uploadImage("NIC", nicLabel));
        pass.addActionListener(e -> uploadImage("Passport Photo", passportLabel));

        submitButton.addActionListener(e -> submitData());

        btnCancel.addActionListener(e -> deleteData());
    }

    private void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PAS", "root", "ayodhya2004");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void uploadImage(String documentType, JLabel label) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            if (selectedFile != null) {
                try {
                    String filePath = selectedFile.getAbsolutePath();

                    // Read the file as bytes
                    byte[] fileBytes = Files.readAllBytes(selectedFile.toPath());

                    // Store the bytes in the database (BLOB)
                    saveImageToDatabase(documentType, fileBytes);

                    // Display the image (optional)
                    ImageIcon imageIcon = new ImageIcon(filePath);
                    label.setIcon(imageIcon);

                    // You can save the file path or handle the file as needed
                    System.out.println("Uploaded " + documentType + " Image: " + filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("File selection was canceled by the user.");
            }
        }
    }


    private void saveImageToDatabase(String documentType, byte[] imageBytes) {
        try {
            int ApplicantId = Integer.parseInt(applicantIdTextField.getText());

            // Construct the SQL query with a specific column name for "Birth Certificate"
            String sql = "UPDATE Documents SET BirthCertificate = ? WHERE ApplicantId = ?";

            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                // Set the parameters, 1 for image data and 2 for the applicantId
                statement.setBytes(1, imageBytes);
                statement.setInt(2, ApplicantId);

                // Execute the update
                statement.executeUpdate();

                System.out.println("Successfully Updated " + documentType + " in the database");
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Update Failed");
            e.printStackTrace();
        }
    }


    private void submitData() {
        try {
            // Assuming you want to submit all three types of documents together
            String BirthCertificate = getFilePath("BirthCertificate");
            String NIC = getFilePath("NIC");
            String PassportPhoto = getFilePath("PaassportPhoto");  // Assuming this is the correct column name

            int ApplicantId = Integer.parseInt(applicantIdTextField.getText());

            // Insert the applicant data into the database
            String query = "INSERT INTO Documents (ApplicantId, BirthCertificate, NIC, PaassportPhoto) VALUES (?, ?, ?, ?)";

            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setInt(1, ApplicantId);

                if (BirthCertificate != null) {
                    statement.setBytes(2, Files.readAllBytes(Paths.get(BirthCertificate)));
                } else {
                    statement.setNull(2, java.sql.Types.BLOB);
                }

                if (NIC != null) {
                    statement.setBytes(3, Files.readAllBytes(Paths.get(NIC)));
                } else {
                    statement.setNull(3, java.sql.Types.BLOB);
                }

                if (PassportPhoto != null) {
                    statement.setBytes(4, Files.readAllBytes(Paths.get(PassportPhoto)));
                } else {
                    statement.setNull(4, java.sql.Types.BLOB);
                }

                statement.executeUpdate();
                System.out.println("Successfully Inserted");
            }
        } catch (IOException | NumberFormatException | SQLException e) {
            System.out.println("Insertion Failed");
            e.printStackTrace();
        }
    }



    private String getFilePath(String documentType) {
        try {
            int ApplicantId = Integer.parseInt(applicantIdTextField.getText());

            // Retrieve the image bytes from the database
            String query = "SELECT " + documentType + " FROM Documents WHERE ApplicantId = ?";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setInt(1, ApplicantId);

                // Execute the query and retrieve the result set
                try (var resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        byte[] imageBytes = resultSet.getBytes(1);

                        // Check if imageBytes is not null
                        if (imageBytes != null) {
                            // Create a unique file name based on current time
                            String fileName = "Saved" + System.currentTimeMillis() + ".jpg";

                            try {
                                Files.write(Paths.get(fileName), imageBytes);
                                System.out.println("Saved " + documentType + " Image to file: " + fileName);
                                return fileName;
                            } catch (IOException e) {
                                System.out.println("Error saving file: " + e.getMessage());
                                return null; // Return null if there's an issue saving the file
                            }
                        } else {
                            System.out.println(documentType + " BLOB data is null for ApplicantId: " + ApplicantId);
                            return null; // Return null if BLOB data is null
                        }
                    } else {
                        System.out.println(documentType + " not found for ApplicantId: " + ApplicantId);
                        return null; // Return null if the document is not found
                    }
                }
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Error retrieving file path for " + documentType);
            e.printStackTrace();
            return null; // Return null in case of an exception
        }
    }




            private void deleteData() {
                try {
                    int ApplicantId = Integer.parseInt(applicantIdTextField.getText());

                    // Delete the applicant data from the database
                    String query = "DELETE FROM Documents WHERE ApplicantId = ?";
                    try (PreparedStatement statement = conn.prepareStatement(query)) {
                        statement.setInt(1, ApplicantId);

                        int rowsAffected = statement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Successfully Deleted");

                            // Clear labels displaying images
                            birthCertificateLabel.setIcon(null);
                            nicLabel.setIcon(null);
                            passportLabel.setIcon(null);
                        } else {
                            System.out.println("No records found for deletion");
                        }
                    }
                } catch (NumberFormatException | SQLException e) {
                    System.out.println("Deletion Failed");
                    e.printStackTrace();
                }
            }

            public static void main(String[] args) {
                SwingUtilities.invokeLater(() -> {
                    ImageUploadForm frame = new ImageUploadForm();
                    frame.setVisible(true);
                });
            }
        }
