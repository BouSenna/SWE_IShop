package Forms;

import javax.swing.ListSelectionModel;
import Database.DBConnect;
import net.proteanit.sql.DbUtils;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Database.DBConnect;
import net.proteanit.sql.DbUtils;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SingleSelectionModel;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class MoreStatistics {

	private int storeid;
	private JFrame frame;
	Connection connection;
    Statement stmt,stmt1 = null;
    ResultSet resultset,resultset1 = null;
    String query="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoreStatistics window = new MoreStatistics();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MoreStatistics() {
		initialize();
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Corbel", Font.PLAIN, 23));
		frame.setBounds(100, 100, 880, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(263, 165, 279, 185);
		frame.getContentPane().add(scrollPane);
		
		JTable table = new JTable();
	
		JLabel lblMoreStatistics = new JLabel("More Statistics");
		lblMoreStatistics.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		lblMoreStatistics.setBounds(255, 16, 393, 39);
		frame.getContentPane().add(lblMoreStatistics);
		
		JLabel lblinvisible = new JLabel("lblinvisible");
		lblinvisible.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblinvisible.setBounds(263, 379, 279, 14);
		frame.getContentPane().add(lblinvisible);
		lblinvisible.setVisible(false);
		
		JComboBox comboBox = new JComboBox();
     	comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Product", "Brand"}));
		comboBox.setBounds(564, 109, 105, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox oprationcomboBox = new JComboBox();
		oprationcomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(oprationcomboBox.getSelectedItem().toString().equals("Count")) {
					comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Product", "Brand" , "Customer" , "Store"}));
				}
			}
		});
		oprationcomboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Count", "Best seller", "Lowest seller"}));
		oprationcomboBox.setBounds(365, 109, 105, 20);
		frame.getContentPane().add(oprationcomboBox);
		
		JButton btnNewButton = new JButton("Show statistics");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				connection = DBConnect.DBConnect(); 
				try {
					String selectedOp = oprationcomboBox.getSelectedItem().toString();
					String selected = comboBox.getSelectedItem().toString();
					stmt1 = connection.createStatement();
					if(selectedOp.equals("Best seller")) {
						query = "select " +selected+"name, (initialquantity-quantity) as RemainingQuantity from product inner join brand on product.brandid = brand.brandid  order by RemainingQuantity asc";
					
					}
					else if(selectedOp.equals("Lowest seller")){
						query =  "select " +selected+"name, (initialquantity-quantity) as RemainingQuantity from product inner join brand on product.brandid = brand.brandid order by RemainingQuantity desc";
					}
					else {
						query = "select count(*) from " + selected;
					}
					stmt = connection.createStatement();
					stmt.setMaxRows(1);
					resultset = stmt.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(resultset));
					scrollPane.setViewportView(table);
					table.setCellSelectionEnabled(true);
				    ListSelectionModel cellSelectionModel = table.getSelectionModel();
				    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					
				}catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(638, 404, 151, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblChooseAnOperation = new JLabel("Choose an operation:");
		lblChooseAnOperation.setFont(new Font("Corbel", Font.PLAIN, 23));
		lblChooseAnOperation.setBounds(81, 98, 271, 39);
		frame.getContentPane().add(lblChooseAnOperation);
		
		
	
	}
}