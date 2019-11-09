package Forms;

import java.awt.EventQueue;

import javax.swing.JFrame;

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
	}

}
