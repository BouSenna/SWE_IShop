package Forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Database.DBConnect;
import Enums.Category;
import Enums.Type;
import Products.Product;
import Stores.Store;

public class addProductForm {

	private JFrame frame;
	private Connection connection;
    private Statement stmt = null;
    ResultSet resultset = null;

	/**
	 * Create the application.
	 */
	public addProductForm() {
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
		
		JLabel lblNewLabel = new JLabel("Add New Product");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		lblNewLabel.setBounds(283, 16, 393, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel Price_Label = new JLabel("Price");
		Price_Label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Price_Label.setBounds(57, 144, 124, 29);
		frame.getContentPane().add(Price_Label);
		
		JLabel Brand_Label = new JLabel("Brand");
		Brand_Label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Brand_Label.setBounds(57, 215, 124, 29);
		frame.getContentPane().add(Brand_Label);
		
		JLabel Item_Label = new JLabel("Item");
		Item_Label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Item_Label.setBounds(463, 215, 124, 29);
		frame.getContentPane().add(Item_Label);
		
		JLabel Name_label = new JLabel("Product Name");
		Name_label.setFont(new Font("Corbel", Font.PLAIN, 23));
		Name_label.setBounds(57, 74, 227, 29);
		frame.getContentPane().add(Name_label);
		
		JLabel SName_label = new JLabel("Your Store ID");
		SName_label.setFont(new Font("Corbel", Font.PLAIN, 23));
		SName_label.setBounds(463, 71, 183, 29);
		frame.getContentPane().add(SName_label);
		
		JLabel quantity_label = new JLabel("Quantity");
		quantity_label.setFont(new Font("Corbel", Font.PLAIN, 23));
		quantity_label.setBounds(463, 144, 183, 29);
		frame.getContentPane().add(quantity_label);
		
		JTextField Quantity_textField = new JTextField();	
		Quantity_textField.setBounds(463, 173, 299, 26);
		frame.getContentPane().add(Quantity_textField);
		Quantity_textField.setColumns(10);
		
		JTextField Name_textField = new JTextField();	
		Name_textField.setBounds(57, 102, 299, 26);
		frame.getContentPane().add(Name_textField);
		Name_textField.setColumns(10);
		
		JTextField Store_textField = new JTextField();	
		Store_textField.setBounds(463, 102, 299, 26);
		frame.getContentPane().add(Store_textField);
		Store_textField.setColumns(10);
		
		JTextField Price_textField = new JTextField();	
		Price_textField.setBounds(57, 173, 299, 26);
		frame.getContentPane().add(Price_textField);
		Price_textField.setColumns(10);
		
		JComboBox ItemcomboBox = new JComboBox();
		ItemcomboBox.setBounds(463, 250, 299, 26);
		try {
        	connection = DBConnect.DBConnect();
        	stmt = connection.createStatement();
            resultset = stmt.executeQuery("select ItemName from ItemSpecs");
			while(resultset.next()) {
				ItemcomboBox.addItem(resultset.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
    	}
		frame.getContentPane().add(ItemcomboBox);

		JComboBox BrandcomboBox = new JComboBox();
		BrandcomboBox.setBounds(57, 250, 299, 26);
		try {
        	connection = DBConnect.DBConnect();
        	stmt = connection.createStatement();
            resultset = stmt.executeQuery("select BrandName from Brand");
			while(resultset.next()) {
				BrandcomboBox.addItem(resultset.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
    	}
		frame.getContentPane().add(BrandcomboBox);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					Product newProduct = new Product();
					newProduct.addProduct(Name_textField.getText(), Integer.parseInt(Price_textField.getText()), 
							Integer.parseInt(Store_textField.getText()), BrandcomboBox.getSelectedItem().toString(), 
							ItemcomboBox.getSelectedItem().toString(),  Integer.parseInt(Quantity_textField.getText()));				
			}
		});
	
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Corbel", Font.PLAIN, 23));
		btnNewButton.setBounds(346, 347, 175, 45);
		frame.getContentPane().add(btnNewButton);
	}

}
