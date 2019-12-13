package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.DBConnect;

///This class is responsible for retrieving the data from the customer table in the database and converting
///it to a meaningful concept for our software.
public class CustomerModel {
	public CustomerModel() {
	}

	/// This function return the balance of the customer with the given credit card
	/// info.
	public int getBalance(String CCInfo) {
		/// Establishing a connection with the database.
		Connection connection = DBConnect.DBConnect();
		int balance = -1;
		try {
			Statement stmt = connection.createStatement();
			/// Getting the account balance of the customer with the given credit card info
			/// and storing it in balance arrayList.
			ResultSet resultset_customer = stmt
					.executeQuery("Select AccountBalance from" + " Customer where CreditCardInfo ='" + CCInfo + "'");
			while (resultset_customer.next()) {
				balance = resultset_customer.getInt(1);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return balance;
	}
}
