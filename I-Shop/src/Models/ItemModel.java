package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DBConnect;

///This class is responsible for retrieving the data from the items table
///in the database and converting it to a meaningful concept for our software.
public class ItemModel {
	Connection connection = null;
	Statement stmt = null;
	ResultSet resultset = null;

	public void ItemModel() {
	}

	/// Method to return the item ID.
	public int getItemID(String itemName) {
		/// Establishing a connection with the database.
		connection = DBConnect.DBConnect();
		int ID = -1;
		try {
			stmt = connection.createStatement();
			/// Getting the ID of an item with the given item name
			/// and storing it in variable ID
			resultset = stmt.executeQuery("select ItemID from Item where ItemName ='" + itemName + "'");
			while (resultset.next()) {
				ID = resultset.getInt(1);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ID;
	}
}