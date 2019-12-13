package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DBConnect;

///This class is responsible for retrieving the data from the store owner table in the database and converting
///it to a meaningful concept for our software.
public class StoreOwnerModel {
	Connection connection = null;
	Statement stmt = null;
	ResultSet resultset = null;

	public StoreOwnerModel() {
	}

	/// Method that adds store owner to its table in the database.
	public void addStoreOwner(int UserID, String UserEmail, String UserPassword, String Name, int NumOfStores,
			int License) {
		/// Establishing a connection with the database.
		connection = DBConnect.DBConnect();
		try {
			stmt = connection.createStatement();
			stmt.execute("insert into [User] (UserID, Email, Password) values " + "('" + UserID + "','" + UserEmail
					+ "','" + UserPassword + "')");
			stmt.execute("insert into StoreOwner  (OwnerName, NumberOfStores, License,  UserID ) values" + " ('" + Name
					+ "','" + NumOfStores + "','" + License + "','" + UserID + "')");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error executing query");
			e.printStackTrace();
		}
	}
}
