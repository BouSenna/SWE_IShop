package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DBConnect;
import Enums.UserTypes;

public class UserModel {
	Connection connection = null;
	Statement stmt = null;
	ResultSet resultset = null;

	public UserModel() {
	}

	public int checkLoginInfo(String Email, String password) {
		try {
			/// Establishing a connection with the database.
			connection = DBConnect.DBConnect();
			stmt = connection.createStatement();

			/// Searching which user type is trying to login and returning the ordinal.
			for (UserTypes type : UserTypes.values()) {
				resultset = stmt.executeQuery("select email,password from [User] inner " + "join " + type.myString()
						+ " on [user].UserID=" + type.myString() + ".UserID");
				while (resultset.next()) {
					if (resultset.getString("email").equals(Email) && resultset.getString("password").equals(password))
						return type.ordinal();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
