package Forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreOwnerHomepageForm {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public StoreOwnerHomepageForm() {
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
		
		JLabel lblNewLabel = new JLabel("I-Shop Store-Owner Home");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		lblNewLabel.setBounds(185, 16, 858, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JButton addStore_button = new JButton("Add new store");
		addStore_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				addStoreForm newForm = new addStoreForm();
			}
		});
		addStore_button.setForeground(Color.BLACK);
		addStore_button.setFont(new Font("Corbel", Font.PLAIN, 23));
		addStore_button.setBackground(Color.LIGHT_GRAY);
		addStore_button.setBounds(313, 206, 237, 39);
		frame.getContentPane().add(addStore_button);
		
		JButton addProduct_button = new JButton("Add new product");
		addProduct_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				addProductForm newForm = new addProductForm();
			}
		});
		addProduct_button.setForeground(Color.BLACK);
		addProduct_button.setFont(new Font("Corbel", Font.PLAIN, 23));
		addProduct_button.setBackground(Color.LIGHT_GRAY);
		addProduct_button.setBounds(313, 151, 237, 39);
		frame.getContentPane().add(addProduct_button);
		
		JButton viewStat_button = new JButton("View Statistics");
		viewStat_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ViewStatistics newForm = new ViewStatistics();
			}
		});
		viewStat_button.setForeground(Color.BLACK);
		viewStat_button.setFont(new Font("Corbel", Font.PLAIN, 23));
		viewStat_button.setBackground(Color.LIGHT_GRAY);
		viewStat_button.setBounds(313, 261, 237, 39);
		frame.getContentPane().add(viewStat_button);
		
		JButton btnAddCollaborator = new JButton("Add collaborator");
		btnAddCollaborator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				AddCollaborator newCollab = new AddCollaborator();
				
			}
			
		});
		btnAddCollaborator.setForeground(Color.BLACK);
		btnAddCollaborator.setFont(new Font("Corbel", Font.PLAIN, 23));
		btnAddCollaborator.setBackground(Color.LIGHT_GRAY);
		btnAddCollaborator.setBounds(313, 315, 237, 39);
		frame.getContentPane().add(btnAddCollaborator);
	}
}
