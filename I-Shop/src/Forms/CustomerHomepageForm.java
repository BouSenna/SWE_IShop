package Forms;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CustomerHomepageForm {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public CustomerHomepageForm() {
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
		
		JLabel lblNewLabel = new JLabel("I-Shop Customer Home");
		lblNewLabel.setBounds(219, 16, 858, 39);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		frame.getContentPane().add(lblNewLabel);
		
		JButton ViewProducts_button = new JButton("View Products");
		ViewProducts_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ViewProducts newForm = new ViewProducts();
			}
		});
		ViewProducts_button.setForeground(Color.BLACK);
		ViewProducts_button.setFont(new Font("Corbel", Font.PLAIN, 23));
		ViewProducts_button.setBackground(Color.LIGHT_GRAY);
		ViewProducts_button.setBounds(313, 152, 237, 39);
		frame.getContentPane().add(ViewProducts_button);
		
	}

}
