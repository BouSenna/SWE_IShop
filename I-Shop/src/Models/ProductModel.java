package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DBConnect;

///This class is responsible for retrieving the data from the product table in the database and converting
///it to a meaningful concept for our software.
public class ProductModel {
	public ProductModel() {
	}

	/// Method to return the available quantity of a product.
	public int getQuantity(String myID) {
		/// Establishing a connection with the database.
		Connection connection = DBConnect.DBConnect();
		int quantity = -1;
		try {
			Statement stmt = connection.createStatement();
			/// Getting the available quantity of the product with the given product ID
			/// and storing it in variable quantity
			ResultSet resultset = stmt.executeQuery("Select Quantity from Product where ProductID ='" + myID + "'");
			while (resultset.next()) {
				quantity = resultset.getInt(1);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return quantity;
	}
}
