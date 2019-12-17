package Forms;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import StoreOwnerCommands.UndoHandler;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CollabActionsTracker {
	public JFrame frame;
	private JTextArea history;
	UndoHandler undoHandler;
	
	/**
	 * Create the application.
	 */
	public CollabActionsTracker(UndoHandler undoHandler) {
		this.undoHandler = undoHandler;
		initialize();
		//frame.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 880, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Collaborator action tracker");
		lblNewLabel.setBounds(128, 16, 662, 39);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("UNDO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				undoHandler.undo();
			}
		});
		btnNewButton.setBounds(345, 404, 184, 29);
		frame.getContentPane().add(btnNewButton);

		JLabel historyLabel = new JLabel("History");
		historyLabel.setBounds(379, 71, 172, 39);
		historyLabel.setFont(new Font("Monospaced", Font.PLAIN, 26));
		frame.getContentPane().add(historyLabel);

		history = new JTextArea();
		history.setFont(new Font("Monospaced", Font.PLAIN, 18));
		history.setBounds(168, 119, 535, 269);
		frame.getContentPane().add(history);
	}
}
