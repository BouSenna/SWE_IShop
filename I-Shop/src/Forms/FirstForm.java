package Forms;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FirstForm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstForm window = new FirstForm();
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
	public FirstForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 880, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("I-Shop");
		label.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 45));
		label.setBounds(339, 16, 163, 68);
		frame.getContentPane().add(label);
		
		JButton Login_Button = new JButton("Login");
		Login_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstForm.this.frame.setVisible(false);
				LoginForm newform = new LoginForm();				
			}
		});
		Login_Button.setBackground(Color.LIGHT_GRAY);
		Login_Button.setForeground(Color.BLACK);
		Login_Button.setFont(new Font("Corbel", Font.PLAIN, 23));
		Login_Button.setBounds(265, 138, 319, 68);
		frame.getContentPane().add(Login_Button);
		
		JButton Register_Button = new JButton("Register");
		Register_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstForm.this.frame.setVisible(false);
				RegisterForm newform = new RegisterForm();				
			}
		});
		Register_Button.setForeground(Color.BLACK);
		Register_Button.setFont(new Font("Corbel", Font.PLAIN, 23));
		Register_Button.setBackground(Color.LIGHT_GRAY);
		Register_Button.setBounds(265, 232, 319, 68);
		frame.getContentPane().add(Register_Button);
	}
}
