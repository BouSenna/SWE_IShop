package Forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Database.DBConnect;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;


public class AdminStatistics {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStatistics window = new AdminStatistics();
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
	public AdminStatistics() {
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
		
		JLabel lblAdminStatistics = new JLabel("Admin Statistics");
		lblAdminStatistics.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		lblAdminStatistics.setBounds(259, 16, 489, 58);
		frame.getContentPane().add(lblAdminStatistics);
     	JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 172, 675, 235);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		Connection connection = DBConnect.DBConnect();
		try {
			Statement stmt = connection.createStatement();
			ResultSet resultset = stmt.executeQuery("Select * from Store");
			table.setModel(DbUtils.resultSetToTableModel(resultset));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    table.setCellSelectionEnabled(true);
	    ListSelectionModel cellSelectionModel = table.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    
		scrollPane.setViewportView(table);
		
		table.addKeyListener(new KeyAdapter() {
	        public void keyPressed(KeyEvent e) {
	            if (e.getKeyCode() == KeyEvent.VK_ENTER){
			    	  Connection connection = DBConnect.DBConnect();
			    	  int row = table.getSelectedRow();
			    	  int col = table.getSelectedColumn();
			    	  String newValue = table.getValueAt(row, col).toString();
			    	  String myID = table.getValueAt(row, 0).toString();	    	  
			    	  Statement stmt;
					try {
						stmt = connection.createStatement();
						stmt.executeUpdate("update Store set [Statistics]='"+newValue+"' where StoreID='"+myID+"'");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
	             }
	        }
	        });
		
	    
	}
	
	
}
