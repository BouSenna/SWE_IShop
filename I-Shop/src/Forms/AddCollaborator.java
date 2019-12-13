package Forms;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Database.DBConnect;

public class AddCollaborator {

	private JFrame frame;
	private JTextField emailTxtField;
	private JTextField passwordTxtField;
	private JTextField nameTxtField;
	private JTextField storeidTxtField;
	private JTextField licenseTxtField;
	private JTextField idTxtField;
	private JLabel lblNewLabel;
	private JLabel lblName;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblStoreId;
	private JLabel lblYourLicenseNumber;
	private JLabel lblYourId;
	private JPanel contentPane;


	/**
	 * Create the application.
	 */
	public AddCollaborator() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 880, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Add collaborators to your store");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		lblNewLabel.setBounds(92, 25, 710, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Corbel", Font.PLAIN, 23));
		lblName.setBounds(92, 98, 103, 29);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Corbel", Font.PLAIN, 23));
		lblEmail.setBounds(92, 158, 123, 29);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Corbel", Font.PLAIN, 23));
		lblPassword.setBounds(92, 217, 134, 29);
		contentPane.add(lblPassword);
		
		nameTxtField = new JTextField();
		nameTxtField.setBounds(92, 127, 235, 20);
		contentPane.add(nameTxtField);
		nameTxtField.setColumns(10);
		
		emailTxtField = new JTextField();
		emailTxtField.setBounds(92, 186, 235, 20);
		contentPane.add(emailTxtField);
		emailTxtField.setColumns(10);
		
		passwordTxtField = new JTextField();
		passwordTxtField.setBounds(92, 244, 235, 20);
		contentPane.add(passwordTxtField);
		passwordTxtField.setColumns(10);
		
		JLabel lblStoreId = new JLabel("Store ID:");
		lblStoreId.setFont(new Font("Corbel", Font.PLAIN, 23));
		lblStoreId.setBounds(453, 102, 111, 21);
		contentPane.add(lblStoreId);
		
		storeidTxtField = new JTextField();
		storeidTxtField.setColumns(10);
		storeidTxtField.setBounds(453, 127, 235, 20);
		contentPane.add(storeidTxtField);
		
		JLabel lblYourLicenseNumber = new JLabel("Your license number:");
		lblYourLicenseNumber.setFont(new Font("Corbel", Font.PLAIN, 23));
		lblYourLicenseNumber.setBounds(453, 158, 208, 23);
		contentPane.add(lblYourLicenseNumber);
		
		licenseTxtField = new JTextField();
		licenseTxtField.setColumns(10);
		licenseTxtField.setBounds(453, 186, 235, 20);
		contentPane.add(licenseTxtField);
		
		JLabel lblYourId = new JLabel("Your ID:");
		lblYourId.setFont(new Font("Corbel", Font.PLAIN, 23));
		lblYourId.setBounds(453, 217, 208, 23);
		contentPane.add(lblYourId);
		
		idTxtField = new JTextField();
		idTxtField.setColumns(10);
		idTxtField.setBounds(453, 244, 235, 20);
		contentPane.add(idTxtField);
		
		JButton btnAddCollab = new JButton("Add collaborator");
		btnAddCollab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection connection = DBConnect.DBConnect();
				try {
					Statement stmt = connection.createStatement();
					stmt.executeUpdate("insert into Collaborators values ('"+Integer.parseInt(licenseTxtField.getText())+"' , '"+Integer.parseInt(idTxtField.getText())+"','"+emailTxtField.getText()+"','"+passwordTxtField.getText()+"','"+nameTxtField.getText()+"')");
					JOptionPane.showMessageDialog(null, "Collaborator added successfully.");
				}
				catch (SQLException e1){
					e1.printStackTrace();
				}
				
			}
		});
		btnAddCollab.setBounds(550, 303, 134, 23);
		contentPane.add(btnAddCollab);
		
	}

}
