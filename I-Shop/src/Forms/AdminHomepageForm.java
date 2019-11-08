package Forms;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AdminHomepageForm {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public AdminHomepageForm() {
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
		
		JLabel lblNewLabel = new JLabel("I-Shop Admin Home");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		lblNewLabel.setBounds(255, 16, 393, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JButton addItem_button = new JButton("Add new item");
		addItem_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			//	addItemForm newForm = new addItemForm();
			}
		});
		addItem_button.setForeground(Color.BLACK);
		addItem_button.setFont(new Font("Corbel", Font.PLAIN, 23));
		addItem_button.setBackground(Color.LIGHT_GRAY);
		addItem_button.setBounds(313, 152, 237, 39);
		frame.getContentPane().add(addItem_button);
		
		JButton addBrand_button = new JButton("Add new brand");
		addBrand_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				addBrandForm newForm = new addBrandForm();
			}
		});
		addBrand_button.setForeground(Color.BLACK);
		addBrand_button.setFont(new Font("Corbel", Font.PLAIN, 23));
		addBrand_button.setBackground(Color.LIGHT_GRAY);
		addBrand_button.setBounds(313, 207, 237, 39);
		frame.getContentPane().add(addBrand_button);
		
		JButton viewReq_button = new JButton("View requests");
		viewReq_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				viewRequests newReq = new viewRequests();
			}
		});
		viewReq_button.setForeground(Color.BLACK);
		viewReq_button.setFont(new Font("Corbel", Font.PLAIN, 23));
		viewReq_button.setBackground(Color.LIGHT_GRAY);
		viewReq_button.setBounds(313, 262, 237, 39);
		frame.getContentPane().add(viewReq_button);
	}
	

}
