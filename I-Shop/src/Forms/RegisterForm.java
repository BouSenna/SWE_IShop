package Forms;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Users.Customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterForm {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public RegisterForm() {
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
		Email_label.setBounds(48, 90, 124, 29);
		frame.getContentPane().add(Email_label);
		
		JLabel Password_Label = new JLabel("Password");
		Password_Label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Password_Label.setBounds(423, 90, 124, 29);
		frame.getContentPane().add(Password_Label);
		
		JLabel Name_label = new JLabel("Username");
		Name_label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Name_label.setBounds(48, 156, 124, 29);
		frame.getContentPane().add(Name_label);
		
		JLabel Address_Label = new JLabel("Address");
		Address_Label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Address_Label.setBounds(423, 156, 124, 29);
		frame.getContentPane().add(Address_Label);
		
		JLabel CCInfo_label = new JLabel("Credit Card Information");
		CCInfo_label.setFont(new Font("Corbel", Font.PLAIN, 23));
		CCInfo_label.setBounds(423, 224, 250, 29);
		frame.getContentPane().add(CCInfo_label);
		
		JLabel MobNum_Label = new JLabel("Mobile Number");
		MobNum_Label.setFont(new Font("Corbel", Font.PLAIN, 23));
		MobNum_Label.setBounds(48, 224, 193, 29);
		frame.getContentPane().add(MobNum_Label);
		
		JLabel AccBalance_Label = new JLabel("Account Balance");
		AccBalance_Label.setFont(new Font("Corbel", Font.PLAIN, 23));
		AccBalance_Label.setBounds(48, 289, 193, 29);
		frame.getContentPane().add(AccBalance_Label);
		
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
		Email_textField.setBounds(48, 114, 299, 26);
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
		Password_textField.setBounds(420, 114, 299, 26);
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
		Name_textField.setBounds(48, 182, 299, 26);
		frame.getContentPane().add(Name_textField);
		Name_textField.setColumns(10);
		
		JTextField Address_textField = new JTextField();
		Address_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char ch = e.getKeyChar();
                if (!(Character.isAlphabetic(ch) || ch == ' ' || ch == '\b' || (ch == KeyEvent.VK_DELETE))) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Only [A-Z, a-z, space character]!");
                }
			}
		});
		Address_textField.setColumns(10);
		Address_textField.setBounds(420, 182, 299, 26);
		frame.getContentPane().add(Address_textField);
		
		JTextField MobNum_textField = new JTextField();
		MobNum_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 char ch = e.getKeyChar();
	                if (!((ch >= '0') && (ch <= '9') || (ch == KeyEvent.VK_DELETE))) {
	                    e.consume();
	                    JOptionPane.showMessageDialog(null, "Only [Numbers]!");
	                }
			}
		});
		MobNum_textField.setColumns(10);
		MobNum_textField.setBounds(48, 247, 299, 26);
		frame.getContentPane().add(MobNum_textField);
		
		JTextField CCInfo_textField = new JTextField();
		CCInfo_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char ch = e.getKeyChar();
                if (!(Character.isAlphabetic(ch) || ch == ' ' || ch == '\b' || (ch == KeyEvent.VK_DELETE))) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Only [A-Z, a-z, space character]!");
                }
			}
		});
		CCInfo_textField.setBounds(423, 247, 299, 26);
		frame.getContentPane().add(CCInfo_textField);
		CCInfo_textField.setColumns(10);
		
		JTextField AccBalance_textField = new JTextField();
		AccBalance_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char ch = e.getKeyChar();
                if (!((ch >= '0') && (ch <= '9') || (ch == KeyEvent.VK_DELETE))) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Only [Numbers]!");
                }
			}
		});
		AccBalance_textField.setColumns(10);
		AccBalance_textField.setBounds(48, 317, 299, 26);
		frame.getContentPane().add(AccBalance_textField);
		
		
		
		JButton SignUp_Button = new JButton("Sign Up");
		SignUp_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if ((Email_textField.getText().trim().length() == 0) || (Password_textField.getText().trim().length() == 0) ||
		                    (Name_textField.getText().trim().length() == 0) || (MobNum_textField.getText().trim().length() == 0) ||
		                    (CCInfo_textField.getText().trim().length() == 0) || (AccBalance_textField.getText().trim().length() == 0) ||
		                    (Address_textField.getText().trim().length() == 0)) {
		                JOptionPane.showMessageDialog(null, "Please Fill all fields.");

		            } else {
		                Customer x = new Customer();
		                x.register(Email_textField.getText(), Password_textField.getText(), Name_textField.getText(), Address_textField.getText(),
		                		CCInfo_textField.getText(), Integer.parseInt(MobNum_textField.getText()), Integer.parseInt(AccBalance_textField.getText()));
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
				Address_textField.setText("");
				MobNum_textField.setText("");
				AccBalance_textField.setText("");
				CCInfo_textField.setText("");
		        JOptionPane.showMessageDialog(null, "Cleared.");
			}
		});
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Corbel", Font.PLAIN, 23));
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setBounds(674, 394, 167, 39);
		frame.getContentPane().add(btnClear);
		
		JLabel lblNewLabel_1 = new JLabel("Register as store-owner");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				StoreOwnerRegistrationForm newForm = new StoreOwnerRegistrationForm();
			}
		});
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(15, 413, 193, 20);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
