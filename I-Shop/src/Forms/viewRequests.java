package Forms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import Database.DBConnect;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class viewRequests {

	private JFrame frame;
	private JTable Store;
	private JScrollPane scrollPane;
	/**
	 * Create the application.
	 */
	public viewRequests() {
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
		
		scrollPane = new JScrollPane();	
		
		scrollPane.setBounds(165, 85, 528, 293);
		frame.getContentPane().add(scrollPane);
		
		Store = new JTable();
		Connection connection = DBConnect.DBConnect();
		try {
			Statement stmt = connection.createStatement();
			ResultSet resultset = stmt.executeQuery("Select * from Store");
			Store.setModel(DbUtils.resultSetToTableModel(resultset));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Store.setCellSelectionEnabled(true);
	    ListSelectionModel cellSelectionModel = Store.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    Store.addKeyListener(new KeyAdapter() {
	        public void keyPressed(KeyEvent e) {
	            if (e.getKeyCode() == KeyEvent.VK_ENTER){
			    	  Connection connection = DBConnect.DBConnect();
			    	  int row = Store.getSelectedRow();
			    	  int col = Store.getSelectedColumn();
			    	  String newValue = Store.getValueAt(row, col).toString();
			    	  String myID = Store.getValueAt(row, 0).toString();	    	  
			    	  Statement stmt;
					try {
						stmt = connection.createStatement();
						stmt.executeUpdate("update Store set Approval='"+newValue+"' where StoreID='"+myID+"'");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
	             }
	        }
	        });
	  
		scrollPane.setViewportView(Store);
		//frame.getContentPane().add(Store);
	}
	
}
