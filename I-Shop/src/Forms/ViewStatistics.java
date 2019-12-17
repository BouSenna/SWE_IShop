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
import Models.StatisticsModel;
import Products.Product;
import Statistics.Statistics;

import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class ViewStatistics {
	JTextArea output_textArea = new JTextArea();

	private JFrame frame;
	/**
	 * Create the application.
	 */
	public ViewStatistics() {
		initialize();
		frame.setVisible(true);
	}
	
	public void appendOutput(ArrayList<String> Output, int size){
		for(int i=0; i<size; i++)
			output_textArea.append(Output.get(i));
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
		
		output_textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		output_textArea.setBounds(96, 172, 675, 235);
		output_textArea.append("Product " +"	      "+" No. of users who bought this product \n");

		frame.getContentPane().add(output_textArea);
	
	
	JButton btnNewButton = new JButton("View");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			new Statistics().viewStat(Integer.parseInt(Store_textField.getText()));
			
		}
	});
	btnNewButton.setBackground(Color.LIGHT_GRAY);
	btnNewButton.setForeground(Color.BLACK);
	btnNewButton.setFont(new Font("Corbel", Font.PLAIN, 23));
	btnNewButton.setBounds(596, 122, 175, 29);
	frame.getContentPane().add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("Admin statistics");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			AdminStatistics adminstat = new AdminStatistics();
			adminstat.view();
		}
	});
	btnNewButton_1.setBounds(562, 419, 137, 23);
	frame.getContentPane().add(btnNewButton_1);
	}
}
