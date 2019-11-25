package Forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Database.DBConnect;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class MoreStatistics {

	private int storeid;
	private JFrame frame;
	Connection connection;
    Statement stmt1,stmt2,stmt3 = null;
    ResultSet resultset1,resultset2,resultset3 = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoreStatistics window = new MoreStatistics(2);
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
	public MoreStatistics(int storeid) {
		this.storeid = storeid;
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
		
		JLabel lblBestSeller = new JLabel("Best seller:");
		lblBestSeller.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblBestSeller.setBounds(108, 112, 151, 84);
		frame.getContentPane().add(lblBestSeller);
		
		JLabel lblMoreStatistics = new JLabel("More Statistics");
		lblMoreStatistics.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		lblMoreStatistics.setBounds(255, 16, 393, 39);
		frame.getContentPane().add(lblMoreStatistics);
		
		JLabel lblBestsellerinvisible = new JLabel("bestsellerinvisible");
		lblBestsellerinvisible.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBestsellerinvisible.setBounds(256, 145, 377, 23);
		frame.getContentPane().add(lblBestsellerinvisible);
		lblBestsellerinvisible.setVisible(false);
		
		JLabel lblnosold = new JLabel("Total number of products sold:");
		lblnosold.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblnosold.setBounds(108, 227, 377, 48);
		frame.getContentPane().add(lblnosold);
		
		JLabel lblNosoldinvisible = new JLabel("nosoldinvisible");
		lblNosoldinvisible.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNosoldinvisible.setBounds(495, 246, 158, 14);
		frame.getContentPane().add(lblNosoldinvisible);
		lblNosoldinvisible.setVisible(false);
		
		JLabel lblRemainingQuantityOf = new JLabel("Remaining quantity of best seller:");
		lblRemainingQuantityOf.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblRemainingQuantityOf.setBounds(108, 179, 425, 48);
		frame.getContentPane().add(lblRemainingQuantityOf);
		
		JLabel remaininginvisible = new JLabel("remainingquantinvisible");
		remaininginvisible.setFont(new Font("Tahoma", Font.PLAIN, 13));
		remaininginvisible.setBounds(526, 199, 151, 14);
		frame.getContentPane().add(remaininginvisible);
		remaininginvisible.setVisible(false);
		
		JButton btnNewButton = new JButton("Show statistics");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		       		connection = DBConnect.DBConnect();
		       		stmt1 = connection.createStatement();
		       		stmt2 = connection.createStatement();
		       		stmt3 = connection.createStatement();
		       		stmt2.setMaxRows(1);
		            resultset1 = stmt1.executeQuery("select [statistics] from store where StoreID='"+storeid+"'");
		            resultset2 = stmt2.executeQuery("select  ProductName,min(InitialQuantity-Quantity) as bestseller from product where storeid='"+storeid+"'  group by ProductName");
		            resultset3 = stmt3.executeQuery("select sum(Quantity) from product where storeid='"+storeid+"'");
		            while(resultset1.next()) {
		            if(resultset1.getObject(1).equals(-1)) {
		            	lblBestsellerinvisible.setText("No info");
		            	lblBestsellerinvisible.setVisible(true); 	
		            	lblNosoldinvisible.setText("No info");
		            	lblNosoldinvisible.setVisible(true); 	
		            	remaininginvisible.setText("No info");
		            	remaininginvisible.setVisible(true);
		            }
		            else {
		            	while(resultset2.next()) {
		            		lblBestsellerinvisible.setText("Most purchased product: " + resultset2.getString(1));
		            		lblBestsellerinvisible.setVisible(true);	
		            		remaininginvisible.setText(resultset2.getString(2));
		            		remaininginvisible.setVisible(true);
		            		while(resultset3.next()) {
		            		lblNosoldinvisible.setText(resultset3.getString(1));
			            	lblNosoldinvisible.setVisible(true);
		            		}
		            	}
		            	
		             }
		           }
		            
				} catch (SQLException e) {
					e.printStackTrace();
			   }
				
			}
		});
		btnNewButton.setBounds(638, 404, 151, 29);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
	}
}
