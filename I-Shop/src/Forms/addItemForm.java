package Forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controllers.ItemController;
import Enums.Category;
import Enums.Type;
import Item.Item;
import Item.Item_Specs;
import Stores.Store;

public class addItemForm {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public addItemForm() {
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

		JLabel lblNewLabel = new JLabel("Add New Item");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		lblNewLabel.setBounds(283, 16, 393, 39);
		frame.getContentPane().add(lblNewLabel);

		JLabel Name_label = new JLabel("Item Name");
		Name_label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Name_label.setBounds(57, 76, 124, 29);
		frame.getContentPane().add(Name_label);

		JLabel minp_Label = new JLabel("Minimum price");
		minp_Label.setFont(new Font("Corbel", Font.PLAIN, 23));
		minp_Label.setBounds(57, 144, 217, 29);
		frame.getContentPane().add(minp_Label);

		JLabel maxp_Label = new JLabel("Maximum price");
		maxp_Label.setFont(new Font("Corbel", Font.PLAIN, 23));
		maxp_Label.setBounds(473, 144, 203, 29);
		frame.getContentPane().add(maxp_Label);

		JLabel Category_Label = new JLabel("Category");
		Category_Label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Category_Label.setBounds(57, 212, 124, 29);
		frame.getContentPane().add(Category_Label);

		JTextField MaximumPrice_textField = new JTextField();
		MaximumPrice_textField.setColumns(10);
		MaximumPrice_textField.setBounds(473, 171, 299, 26);
		frame.getContentPane().add(MaximumPrice_textField);

		JTextField MinimumPrice_textField = new JTextField();
		MinimumPrice_textField.setColumns(10);
		MinimumPrice_textField.setBounds(57, 171, 299, 26);
		frame.getContentPane().add(MinimumPrice_textField);

		JTextField Name_textField = new JTextField();
		Name_textField.setBounds(57, 102, 299, 26);
		frame.getContentPane().add(Name_textField);
		Name_textField.setColumns(10);

		JComboBox categorycomboBox = new JComboBox();
		categorycomboBox.setBounds(57, 243, 299, 26);
		for (Category cat : Category.values()) {
			categorycomboBox.addItem(cat.myString());
		}
		frame.getContentPane().add(categorycomboBox);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ItemController().addItem(Integer.parseInt(MinimumPrice_textField.getText()),
						Integer.parseInt(MaximumPrice_textField.getText()));
				Item_Specs newSpec = new Item_Specs();
				newSpec.addItemSpecs(Name_textField.getText(), categorycomboBox.getSelectedItem().toString());
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Corbel", Font.PLAIN, 23));
		btnNewButton.setBounds(391, 357, 133, 48);
		frame.getContentPane().add(btnNewButton);
	}

}
