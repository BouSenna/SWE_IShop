package Forms;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Brands.Brand;
import Enums.Category;
import Enums.UserTypes;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class addBrandForm {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public addBrandForm() {
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
		
		JLabel lblNewLabel = new JLabel("Add New Brand");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		lblNewLabel.setBounds(283, 16, 393, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel Category_Label = new JLabel("Category");
		Category_Label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Category_Label.setBounds(78, 189, 124, 29);
		frame.getContentPane().add(Category_Label);
		
		JLabel Name_label = new JLabel("Brand Name");
		Name_label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Name_label.setBounds(78, 111, 124, 29);
		frame.getContentPane().add(Name_label);
		
		JTextField Name_textField = new JTextField();	
		Name_textField.setBounds(78, 139, 299, 26);
		frame.getContentPane().add(Name_textField);
		Name_textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(78, 222, 299, 26);
    	for (Category cat : Category.values()) {
    		comboBox.addItem(cat.myString());
    	}
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Brand newBrand = new Brand();
				newBrand.addBrand(Name_textField.getText(), comboBox.getSelectedItem().toString());
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Corbel", Font.PLAIN, 23));
		btnNewButton.setBounds(346, 347, 175, 45);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
