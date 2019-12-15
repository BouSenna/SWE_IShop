package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DBConnect;
import Item.Item_Specs;

///This class is responsible for retrieving the data from itemSpecs table
///in the database and converting it to a meaningful concept for our software.
public class ItemSpecsModel {
	Connection connection = null;
	Statement stmt = null;
	ResultSet resultset = null;

	public ItemSpecsModel() {
	}

	/// Method to add item specifications to its table in the database.
	public void addItemSpecs(String Name, String Category) {
		/// Establishing a connection with the database.
		connection = DBConnect.DBConnect();
		try {
			stmt = connection.createStatement();
			stmt.execute("insert into itemspecs values ('" + Name + "','" + Category + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/// Method that checks if there exists an item with the given specs.
	public boolean matches(Item_Specs item) {
		try {
			/// Establishing a connection with the database.
			connection = DBConnect.DBConnect();
			stmt = connection.createStatement();
			resultset = stmt.executeQuery("select ItemName, Category from ItemSpecs");
			while (resultset.next()) {
				if ((resultset.getString(1).toUpperCase()).equals(item.getName().toUpperCase())
						&& (resultset.getString(2).toUpperCase()).equals(item.getCategory().toUpperCase()))
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
