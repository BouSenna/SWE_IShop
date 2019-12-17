package Forms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controllers.StoreController;
import Enums.Category;
import Enums.Type;

public class addStoreForm {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public addStoreForm() {
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
		
		
		JLabel lblNewLabel = new JLabel("Add New store");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		lblNewLabel.setBounds(283, 16, 393, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel Category_Label = new JLabel("Category");
		Category_Label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Category_Label.setBounds(57, 212, 124, 29);
		frame.getContentPane().add(Category_Label);
		
		JLabel Name_label = new JLabel("Store Name");
		Name_label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Name_label.setBounds(57, 76, 124, 29);
		frame.getContentPane().add(Name_label);
		
		JLabel Address_Label = new JLabel("Address");
		Address_Label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Address_Label.setBounds(463, 76, 124, 29);
		frame.getContentPane().add(Address_Label);
		
		JLabel StoreType_Label = new JLabel("Store type");
		StoreType_Label.setFont(new Font("Corbel", Font.PLAIN, 23));
		StoreType_Label.setBounds(463, 212, 124, 29);
		frame.getContentPane().add(StoreType_Label);
		
		JLabel license_Label = new JLabel("Your license number");
		license_Label.setFont(new Font("Corbel", Font.PLAIN, 23));
		license_Label.setBounds(57, 144, 226, 29);
		frame.getContentPane().add(license_Label);
		
		JTextField Address_textField = new JTextField();
		Address_textField.setColumns(10);
		Address_textField.setBounds(463, 102, 299, 26);
		frame.getContentPane().add(Address_textField);
		
		JTextField Name_textField = new JTextField();	
		Name_textField.setBounds(57, 102, 299, 26);
		frame.getContentPane().add(Name_textField);
		Name_textField.setColumns(10);
		
		JTextField License_textField = new JTextField();
		License_textField.setColumns(10);
		License_textField.setBounds(57, 169, 299, 26);
		frame.getContentPane().add(License_textField);
    	
		
		JComboBox typecomboBox = new JComboBox();
		typecomboBox.setBounds(463, 238, 299, 26);
    	for (Type t : Type.values()) {
    		typecomboBox.addItem(t.myString());
    	}
		frame.getContentPane().add(typecomboBox);

		JComboBox categorycomboBox = new JComboBox();
		categorycomboBox.setBounds(57, 238, 299, 26);
		for (Category cat : Category.values()) {
    		categorycomboBox.addItem(cat.myString());
    	}
		frame.getContentPane().add(categorycomboBox);
		
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StoreController().addStore(Name_textField.getText(), categorycomboBox.getSelectedItem().toString(), typecomboBox.getSelectedItem().toString(), Address_textField.getText(), Integer.parseInt(License_textField.getText()));
				
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Corbel", Font.PLAIN, 23));
		btnNewButton.setBounds(346, 347, 175, 45);
		frame.getContentPane().add(btnNewButton);
	}

}
