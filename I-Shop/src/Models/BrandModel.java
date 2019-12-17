package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Brands.Brand;
import Database.DBConnect;

///This class is responsible for retrieving the data from the brand table
///in the database and converting it to a meaningful concept for our software.
public class BrandModel {
	Connection connection = null;
	Statement stmt = null;
	ResultSet resultset = null;

	public BrandModel() {
	}

	/// Method to return the brand ID.
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

	/// Method that adds new brand to the table in the database
	public void addBrand(String Name, String Category) {
		connection = DBConnect.DBConnect();
		try {
			stmt = connection.createStatement();
			stmt.execute("insert into Brand (BrandName, Category) values ('" + Name + "','" + Category + "')");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error executing query");
			e.printStackTrace();
		}
	}

	/// Method that searches whether the brand is in the system or not.
	public boolean matches(Brand brand) {
		try {
			ResultSet resultset = null;
			connection = DBConnect.DBConnect();
			stmt = connection.createStatement();
			resultset = stmt.executeQuery("select BrandName, Category from Brand");
			while (resultset.next()) {
				if ((resultset.getString(1).toUpperCase()).equals(brand.getName().toUpperCase())
						&& (resultset.getString(2).toUpperCase()).equals(brand.getCategory().toUpperCase()))
					return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
