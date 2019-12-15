package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DBConnect;

///This class is responsible for retrieving the data from itemSpecs table
///in the database and converting it to a meaningful concept for our software.
public class ItemSpecsModel {
	Connection connection = null;
	Statement stmt = null;
	ResultSet resultset = null;

	public ItemSpecsModel() {
	}

	/// Method to add item specifications to its table in the database.
	public void addItemSpects(String Name, String Category) {
		/// Establishing a connection with the database.
		connection = DBConnect.DBConnect();
		try {
			stmt = connection.createStatement();
			stmt.execute("insert into itemspecs values ('" + Name + "','" + Category + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}