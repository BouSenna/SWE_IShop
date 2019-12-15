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

	/// Method that returns the minimum price.
	public int getMin(int ID) {
		/// Establishing a connection with the database.
		connection = DBConnect.DBConnect();
		int minPrice = -1;
		try {
			stmt = connection.createStatement();
			/// Getting the minimum price of an item with the given item ID
			/// and storing it in variable minPrice
			resultset = stmt.executeQuery("select MinPrice from Item where ItemID ='" + ID + "'");
			while (resultset.next()) {
				minPrice = resultset.getInt(1);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return minPrice;
	}

	/// Method that returns the maximum price.
	public int getMax(int ID) {
		/// Establishing a connection with the database.
		connection = DBConnect.DBConnect();
		int maxPrice = -1;
		try {
			stmt = connection.createStatement();
			/// Getting the maximum price of an item with the given item ID
			/// and storing it in variable maxPrice
			resultset = stmt.executeQuery("select MaxPrice from Item where ItemID ='" + ID + "'");
			while (resultset.next()) {
				maxPrice = resultset.getInt(1);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return maxPrice;
	}

	/// Method that adds items in the database.
	public void addItem(int minPrice, int maxPrice) {
		connection = DBConnect.DBConnect();
		try {
			stmt = connection.createStatement();
			stmt.execute("insert into items (MaxPrice, MinPrice) values ('" + maxPrice + "','" + minPrice + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/// Method that checks whether the price of a product is valid (in range of the
	/// item price) or not.
	public boolean inRange(int num, int ID) {
		int MinPrice = getMin(ID);
		int MaxPrice = getMax(ID);
		if (num >= MinPrice && num <= MaxPrice)
			return true;
		return false;
	}
}
