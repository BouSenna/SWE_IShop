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
	Connection connection = null;
	Statement stmt = null;
	ResultSet resultset = null;

	public CustomerModel() {
	}

	/// This function return the balance of the customer with the given credit card
	/// info.
	public int getBalance(String CCInfo) {
		/// Establishing a connection with the database.
		connection = DBConnect.DBConnect();
		int balance = -1;
		try {
			stmt = connection.createStatement();
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

	/// Method update the account balance of a customer in the database.
	public void updateBalance(String CCInfo, int Balance) {
		/// Establishing a connection with the database.
		connection = DBConnect.DBConnect();
		try {
			/// Updating the account balance of a customer -with the given credit card info-
			/// with the new balance.
			stmt = connection.createStatement();
			stmt.executeUpdate(
					"update Customer set AccountBalance='" + Balance + "' where CreditCardInfo ='" + CCInfo + "'");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	/// Method to add new customer
	public void addNewCustomer(String UserEmail, String UserPassword, String Name, String Address,
			String CreditCardInfo, int MobileNumber, float AccountBalance) {
		try {
			int temp = 0;
			stmt = connection.createStatement();
			stmt.execute("insert into [User] (Email,Password) values ('" + UserEmail + "','" + UserPassword + "')");
			resultset = stmt.executeQuery("select userid from [user] where email = '" + UserEmail + "' AND password = '"
					+ UserPassword + "' ");
			while (resultset.next())
				temp = resultset.getInt(1);

			stmt.execute(
					"insert into customer  (UserID,CustomerName, Address,MobileNumber,AccountBalance,CreditCardinfo) values ('"
							+ temp + "','" + Name + "','" + Address + "','" + MobileNumber + "','" + AccountBalance
							+ "','" + CreditCardInfo + "')");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error executing query");
			e.printStackTrace();
		}
	}
}
