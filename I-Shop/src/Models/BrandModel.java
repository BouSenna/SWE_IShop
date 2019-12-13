package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DBConnect;

///This class is responsible for retrieving the data from the brand table
///in the database and converting it to a meaningful concept for our software.
public class BrandModel {
	Connection connection = null;
	Statement stmt = null;
	ResultSet resultset = null;

	public BrandModel() {
	}

	///  Method to return the brand ID.
	public int getBrandID(String brandName) {
		/// Establishing a connection with the database.
		connection = DBConnect.DBConnect();
		int ID = -1;
		try {
			stmt = connection.createStatement();
			/// Getting the brand ID of the brand with the given brand name
			/// and storing it in variable ID.
			resultset = stmt.executeQuery("select BrandID from Brand where BrandName ='" + brandName + "'");
			while (resultset.next()) {
				ID = resultset.getInt(1);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ID;
	}
}
