package Forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Users.StoreOwner;

public class StoreOwnerRegistrationForm {

	private JFrame frame;
	/**
	 * Create the application.
	 */
	public StoreOwnerRegistrationForm() {
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
		
		JLabel lblNewLabel = new JLabel("I-Shop Registration");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		lblNewLabel.setBounds(219, 16, 858, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel Email_label = new JLabel("Email");
		Email_label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Email_label.setBounds(78, 90, 124, 29);
		frame.getContentPane().add(Email_label);
		
		JLabel Password_Label = new JLabel("Password");
		Password_Label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Password_Label.setBounds(78, 167, 124, 29);
		frame.getContentPane().add(Password_Label);
		
		JLabel Name_label = new JLabel("Username");
		Name_label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Name_label.setBounds(78, 256, 124, 29);
		frame.getContentPane().add(Name_label);
		
		JTextField Email_textField = new JTextField();
		Email_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char ch = e.getKeyChar();
                if (!(Character.isAlphabetic(ch) || ch == ' ' || ch == '\b' || (ch == KeyEvent.VK_DELETE) || ch == '@' || ch == '.')) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Only [A-Z, a-z, space, @ and . characters]!");
                }
			}
		});
		Email_textField.setBounds(78, 114, 299, 26);
		frame.getContentPane().add(Email_textField);
		Email_textField.setColumns(10);
		
		JTextField Password_textField = new JTextField();
		Password_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 char ch = e.getKeyChar();
	                if (!((ch >= '0') && (ch <= '9') || (ch == KeyEvent.VK_BACK_SPACE) || (ch == KeyEvent.VK_DELETE) || Character.isAlphabetic(ch))) {
	                    e.consume();
	                    JOptionPane.showMessageDialog(null, "Only Numbers & Alphabetics...!");
	                }
			}
		});
		Password_textField.setColumns(10);
		Password_textField.setBounds(78, 191, 299, 26);
		frame.getContentPane().add(Password_textField);
		
		JTextField Name_textField = new JTextField();
		Name_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char ch = e.getKeyChar();
                if (!(Character.isAlphabetic(ch) || ch == ' ' || ch == '\b' || (ch == KeyEvent.VK_DELETE))) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Only [A-Z, a-z, space character]!");
                }
			}
		});
		Name_textField.setBounds(78, 280, 299, 26);
		frame.getContentPane().add(Name_textField);
		Name_textField.setColumns(10);
		
		JButton SignUp_Button = new JButton("Sign Up");
		SignUp_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if ((Email_textField.getText().trim().length() == 0) || (Password_textField.getText().trim().length() == 0) ||
		                    (Name_textField.getText().trim().length() == 0)) {
		                JOptionPane.showMessageDialog(null, "Please Fill all fields.");

		            } else {
		                StoreOwner x = new StoreOwner();
		                x.register(Email_textField.getText(), Password_textField.getText(), Name_textField.getText());
		                JOptionPane.showMessageDialog(null, "Your information is saved successfully.");
		            }
			}
		});
		SignUp_Button.setBackground(Color.LIGHT_GRAY);
		SignUp_Button.setForeground(Color.BLACK);
		SignUp_Button.setFont(new Font("Corbel", Font.PLAIN, 23));
		SignUp_Button.setBounds(300, 394, 167, 39);
		frame.getContentPane().add(SignUp_Button);
		
		JButton Cancel_button = new JButton("Cancel");
		Cancel_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure to close this window?");

	            if (result == JOptionPane.YES_OPTION) {
	                System.exit(0);
	            }
			}
		});
		Cancel_button.setForeground(Color.BLACK);
		Cancel_button.setFont(new Font("Corbel", Font.PLAIN, 23));
		Cancel_button.setBackground(Color.LIGHT_GRAY);
		Cancel_button.setBounds(492, 394, 167, 39);
		frame.getContentPane().add(Cancel_button);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Email_textField.setText("");
				Password_textField.setText("");
				Name_textField.setText("");
		        JOptionPane.showMessageDialog(null, "Cleared.");
			}
		});
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Corbel", Font.PLAIN, 23));
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setBounds(674, 394, 169, 39);
		frame.getContentPane().add(btnClear);
	}

}
