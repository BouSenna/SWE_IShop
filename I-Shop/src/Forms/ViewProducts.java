package Forms;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import Database.DBConnect;
import net.proteanit.sql.DbUtils;

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
		
		JLabel lblNewLabel = new JLabel("Store Owner Requests");
		lblNewLabel.setBounds(197, 0, 489, 58);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		frame.getContentPane().add(lblNewLabel);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 74, 710, 305);
		frame.getContentPane().add(scrollPane);
		
		JTable products = new JTable();
		Connection connection = DBConnect.DBConnect();
		try {
			Statement stmt = connection.createStatement();
			ResultSet resultset = stmt.executeQuery("Select * from Product");
			products.setModel(DbUtils.resultSetToTableModel(resultset));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scrollPane.setViewportView(products);
	}

}
