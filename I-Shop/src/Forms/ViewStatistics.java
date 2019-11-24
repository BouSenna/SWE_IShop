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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Database.DBConnect;
import Products.Product;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class ViewStatistics {

	private JFrame frame;
	/**
	 * Create the application.
	 */
	public ViewStatistics() {
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
		
		JLabel lblNewLabel = new JLabel("Store statistics");
		lblNewLabel.setBounds(259, 16, 489, 58);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel SName_label = new JLabel("Your Store ID");
		SName_label.setFont(new Font("Corbel", Font.PLAIN, 23));
		SName_label.setBounds(96, 90, 183, 29);
		frame.getContentPane().add(SName_label);
		
		JTextField Store_textField = new JTextField();	
		Store_textField.setBounds(96, 123, 299, 26);
		frame.getContentPane().add(Store_textField);
		Store_textField.setColumns(10);
		
		JTextArea output_textArea = new JTextArea();
		output_textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		output_textArea.setBounds(96, 172, 675, 235);
		output_textArea.append("Product " +"	      "+" No. of users who bought this product \n");

		frame.getContentPane().add(output_textArea);
	
	
	JButton btnNewButton = new JButton("View");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				Connection connection;
			    Statement stmt = null;
			    ResultSet resultset = null;
	       		connection = DBConnect.DBConnect();
	       		stmt = connection.createStatement();
	            resultset = stmt.executeQuery("select ProductName, InitialQuantity, Quantity from Product where StoreID = '"+Integer.parseInt(Store_textField.getText())+"' ");
	            while(resultset.next()) {
					if (resultset.getInt(2) - resultset.getInt(3) != resultset.getInt(2))
						output_textArea.append(resultset.getString(1) +"			"+Integer.toString(resultset.getInt(2)-resultset.getInt(3))+"\n");
					else 
						output_textArea.append(resultset.getString(1) +"			"+"Sold out \n");
	            }
	            
			} catch (SQLException e) {
				e.printStackTrace();
		   }
		}
	});
	btnNewButton.setBackground(Color.LIGHT_GRAY);
	btnNewButton.setForeground(Color.BLACK);
	btnNewButton.setFont(new Font("Corbel", Font.PLAIN, 23));
	btnNewButton.setBounds(596, 122, 175, 29);
	frame.getContentPane().add(btnNewButton);
	
	JLabel lblViewAdminStatistics = new JLabel("View Admin Statistics");
	lblViewAdminStatistics.setForeground(SystemColor.textHighlight);
	lblViewAdminStatistics.setBounds(664, 406, 105, 37);
	frame.getContentPane().add(lblViewAdminStatistics);
	}
}
