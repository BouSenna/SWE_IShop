package Forms;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Users.Customer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class LoginForm {

	private JFrame frame;
	private JTextField Usename_textField;
	private JTextField Password_textField;
	
	/**
	 * Create the application.
	 */
	public LoginForm() {
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
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("I-Shop Login");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		lblNewLabel.setBounds(296, 16, 238, 61);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel Username_label = new JLabel("Username");
		Username_label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Username_label.setBounds(177, 107, 124, 29);
		frame.getContentPane().add(Username_label);
		
		JLabel Password_Label = new JLabel("Password");
		Password_Label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Password_Label.setBounds(177, 181, 124, 29);
		frame.getContentPane().add(Password_Label);
		
		Usename_textField = new JTextField();
		Usename_textField.setBounds(316, 108, 299, 26);
		frame.getContentPane().add(Usename_textField);
		Usename_textField.setColumns(10);
		
		Password_textField = new JTextField();
		Password_textField.setColumns(10);
		Password_textField.setBounds(316, 182, 299, 26);
		frame.getContentPane().add(Password_textField);
		
		JButton Login_Button = new JButton("Login");
		Login_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Customer x = new Customer();
                switch (x.login(Usename_textField.getText(), Password_textField.getText())) {
                	case 0: 
                		new DisplayMessages().displayMessage("Login successfully, welcome to I-Shop");
                        frame.setVisible(false);
                        CustomerHomepageForm customerNewForm = new CustomerHomepageForm();
                        break;
                	case 1:
                		new DisplayMessages().displayMessage("Login successfully, welcome to I-Shop");
                        frame.setVisible(false);
                        AdminHomepageForm adminNewForm = new AdminHomepageForm();
                        break;
                	case 2:
                		new DisplayMessages().displayMessage("Login successfully, welcome to I-Shop");
                        frame.setVisible(false);
                        StoreOwnerHomepageForm ownerNewForm = new StoreOwnerHomepageForm();
                        break;
                	case 3:
                		new DisplayMessages().displayMessage("Login successfully, welcome to I-Shop");
                        frame.setVisible(false);
                        StoreOwnerHomepageForm collaboratorNewForm = new StoreOwnerHomepageForm();
                        break;
                	case -1: 
                		new DisplayMessages().displayMessage("Incorrect email or password");
                       break;
                }
			}
		});
		
		Login_Button.setBackground(Color.LIGHT_GRAY);
		Login_Button.setForeground(Color.BLACK);
		Login_Button.setFont(new Font("Corbel", Font.PLAIN, 23));
		Login_Button.setBounds(262, 297, 319, 68);
		frame.getContentPane().add(Login_Button);
	}
}
