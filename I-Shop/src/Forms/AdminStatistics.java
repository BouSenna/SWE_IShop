package Forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Statistics.StatisticsObserver;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class AdminStatistics implements StatisticsObserver{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStatistics window = new AdminStatistics();
					window.frame.setVisible(false);
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
		frame.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 880, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMoreStats = new JLabel("More statistics");
		lblMoreStats.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		lblMoreStats.setBounds(252, 11, 321, 66);
		frame.getContentPane().add(lblMoreStats);
		
	}
	
	public void view() {
		frame.setVisible(true);
	}

	@Override
	public void update(ResultSet resultset, String stat) {
		frame.setVisible(true);
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(149, 83, 540, 202);
		frame.getContentPane().add(textArea_1);
		String text = "";
		text += stat + ":  ";
		try {
			while(resultset.next()){
				text += resultset.getObject(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textArea_1.setText(text);

		
	}
}
