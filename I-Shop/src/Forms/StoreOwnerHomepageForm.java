package Forms;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import StoreOwnerCommands.UndoHandler;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class StoreOwnerHomepageForm {

	private JFrame frame;
	private UndoHandler undoHandler;

	/**
	 * Create the application.
	 */
	public StoreOwnerHomepageForm() {
		undoHandler = new UndoHandler();
		initialize();
		frame.setVisible(true);
	}

	private boolean checkAuthority() {
		String input = JOptionPane.showInputDialog("Enter the store password please");
		if (input.equals("owner123")) {
			frame.setVisible(false);
			return true;
		}
		return false;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 880, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("I-Shop Store-Owner Home");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		lblNewLabel.setBounds(185, 16, 858, 39);
		frame.getContentPane().add(lblNewLabel);

		JButton addStore_button = new JButton("Add new store");
		addStore_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkAuthority()) {
					frame.setVisible(false);
					addStoreForm newForm = new addStoreForm();
				} else
					new DisplayMessages().displayMessage("Not supported for this account.");
			}
		});
		addStore_button.setForeground(Color.BLACK);
		addStore_button.setFont(new Font("Corbel", Font.PLAIN, 23));
		addStore_button.setBackground(Color.LIGHT_GRAY);
		addStore_button.setBounds(313, 206, 237, 39);
		frame.getContentPane().add(addStore_button);

		JButton addProduct_button = new JButton("Add new product");
		addProduct_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addProductForm newForm = new addProductForm(undoHandler);
			}
		});
		addProduct_button.setForeground(Color.BLACK);
		addProduct_button.setFont(new Font("Corbel", Font.PLAIN, 23));
		addProduct_button.setBackground(Color.LIGHT_GRAY);
		addProduct_button.setBounds(313, 151, 237, 39);
		frame.getContentPane().add(addProduct_button);

		JButton viewStat_button = new JButton("View Statistics");
		viewStat_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkAuthority()) {
					frame.setVisible(false);
					ViewStatistics newForm = new ViewStatistics();
				} else
					new DisplayMessages().displayMessage("Not supported for this account.");
			}
		});
		viewStat_button.setForeground(Color.BLACK);
		viewStat_button.setFont(new Font("Corbel", Font.PLAIN, 23));
		viewStat_button.setBackground(Color.LIGHT_GRAY);
		viewStat_button.setBounds(313, 261, 237, 39);
		frame.getContentPane().add(viewStat_button);

		JButton btnAddCollaborator = new JButton("Add collaborator");
		btnAddCollaborator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkAuthority()) {
					frame.setVisible(false);
					AddCollaborator newCollab = new AddCollaborator();
				} else
					new DisplayMessages().displayMessage("Not supported for this account.");
			}

		});
		btnAddCollaborator.setForeground(Color.BLACK);
		btnAddCollaborator.setFont(new Font("Corbel", Font.PLAIN, 23));
		btnAddCollaborator.setBackground(Color.LIGHT_GRAY);
		btnAddCollaborator.setBounds(313, 315, 237, 39);
		frame.getContentPane().add(btnAddCollaborator);

		JLabel lblNewLabel_1 = new JLabel("Store owner privileges");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (checkAuthority())
					undoHandler.tracker.frame.setVisible(true);
				else
					new DisplayMessages().displayMessage("Not supported for this account.");
			}
		});
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(15, 413, 193, 20);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
