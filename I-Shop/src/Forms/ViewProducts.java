package Forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import Database.DBConnect;
import Users.Customer;
import net.proteanit.sql.DbUtils;
import java.sql.Statement;
import Controllers.CustomerController;;


public class ViewProducts {

	private JFrame frame;
	/**
	 * Create the application.
	 */
	public ViewProducts() {
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
		
		JLabel lblNewLabel = new JLabel("Products");
		lblNewLabel.setBounds(307, 0, 489, 58);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 74, 712, 171);
		frame.getContentPane().add(scrollPane);
		
		JTable products = new JTable();
		Connection connection = DBConnect.DBConnect();
		try {
			Statement stmt = connection.createStatement();
			ResultSet resultset = stmt.executeQuery("Select ProductID, ProductName, ProductPrice from Product");
			products.setModel(DbUtils.resultSetToTableModel(resultset));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scrollPane.setViewportView(products);
		
		JLabel QuantityLabel = new JLabel("Quantity");
		QuantityLabel.setBounds(106, 261, 183, 29);
		QuantityLabel.setFont(new Font("Corbel", Font.PLAIN, 23));
		frame.getContentPane().add(QuantityLabel);
		
		JLabel CCInfo = new JLabel("Your CC information");
		CCInfo.setBounds(106, 328, 286, 29);
		CCInfo.setFont(new Font("Corbel", Font.PLAIN, 23));
		frame.getContentPane().add(CCInfo);
		
		JLabel addressLabel = new JLabel("Your shipping address");
		addressLabel.setBounds(473, 261, 330, 29);
		addressLabel.setFont(new Font("Corbel", Font.PLAIN, 23));
		frame.getContentPane().add(addressLabel);
		
		JTextField Quantity_textField = new JTextField();	
		Quantity_textField.setBounds(106, 286, 226, 26);
		frame.getContentPane().add(Quantity_textField);
		Quantity_textField.setColumns(10);
		
		JTextField CCInfo_textField = new JTextField();	
		CCInfo_textField.setBounds(106, 354, 226, 26);
		frame.getContentPane().add(CCInfo_textField);
		CCInfo_textField.setColumns(10);
		
		JTextField address_textField = new JTextField();	
		address_textField.setBounds(473, 286, 226, 26);
		frame.getContentPane().add(address_textField);
		address_textField.setColumns(10);
		
		    	  
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				products.setCellSelectionEnabled(true);
	    	    ListSelectionModel cellSelectionModel = products.getSelectionModel();
	    	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    	    int row = products.getSelectedRow();
	    	    int column = 0;
	    	    String myID = products.getModel().getValueAt(row, column).toString();	
		        new CustomerController().buyProduct(CCInfo_textField.getText(), myID, Integer.parseInt(Quantity_textField.getText()));
			}
		});
		btnBuy.setForeground(Color.BLACK);
		btnBuy.setFont(new Font("Corbel", Font.PLAIN, 23));
		btnBuy.setBackground(Color.LIGHT_GRAY);
		btnBuy.setBounds(292, 396, 268, 37);
		frame.getContentPane().add(btnBuy);	
	}
}
