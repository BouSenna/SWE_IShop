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
	public void addStoreOwner(String UserEmail, String UserPassword, String Name) {
		/// Establishing a connection with the database.
		connection = DBConnect.DBConnect();
		try {
			int temp = 0;
			stmt = connection.createStatement();
			stmt.execute("insert into [User] ( Email, Password) values " + "('" + UserEmail
					+ "','" + UserPassword + "')");
			resultset = stmt.executeQuery(
					"select userid from [user] where email = '" + UserEmail + "' AND password = '" + UserPassword + "' ");
			while (resultset.next())
				temp = resultset.getInt(1);
			stmt.execute("insert into StoreOwner  (OwnerName, UserID ) values" + " ('" + Name
					+ "','" + temp + "')");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error executing query");
			e.printStackTrace();
		}
	}
}
