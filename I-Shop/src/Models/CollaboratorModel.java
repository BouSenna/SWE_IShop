package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Database.DBConnect;

///This class is responsible for retrieving the data from the collaborator table
///in the database and converting it to a meaningful concept for our software.
public class CollaboratorModel {
	Connection connection = null;
	Statement stmt = null;
	ResultSet resultset = null;

	public CollaboratorModel() {
	}

	// Method to add collaborator to the database.
	public void AddCollaborator(int license, int ID, String email, String password, String name) {
		int temp = 0;
		Connection connection = DBConnect.DBConnect();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("insert into [user] values ('" + email + "','" + password + "')");
			resultset = stmt.executeQuery(
					"select userid from [user] where email = '" + email + "' AND password = '" + password + "' ");
			while (resultset.next())
				temp = resultset.getInt(1);
			stmt.executeUpdate("insert into Collaborators   values ('" + license + "' , '" + ID + "','" + name + "','"
					+ temp + "')");

			JOptionPane.showMessageDialog(null, "Collaborator added successfully.");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

}
