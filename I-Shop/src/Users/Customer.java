package Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Database.DBConnect;

public class Customer extends User implements CustomerInterface {
	private String mName;
	private String mAddress;
	private String mCreditCardInfo;
	private int mMobileNumber;
	private float mAccountBalance;
	Connection connection = null;
	Statement stmt = null;

	public Customer() {
		mName = "";
		mAddress = "";
		mCreditCardInfo = "";
		mMobileNumber = 0;
		mAccountBalance = 0;

	}

	public void setName(String name) {
		this.mName = name;
	}

	public String getName() {
		return this.mName;
	}

	public void setAddress(String address) {
		this.mAddress = address;
	}

	public String getAddress() {
		return this.mAddress;
	}

	public void setCCInfo(String ccinfo) {
		this.mCreditCardInfo = ccinfo;
	}

	public String getCCInfo() {
		return this.mCreditCardInfo;
	}

	public void setMobNum(int num) {
		this.mMobileNumber = num;
	}

	public int getMobNum() {
		return this.mMobileNumber;
	}

	public void setAccBalance(float balance) {
		this.mAccountBalance = balance;
	}

	public float getAccBalance() {
		return this.mAccountBalance;
	}

	public void register(String email, String password, String name, String address, String creditCardInfo, int mobNum,
			float accountBalance) {
		mUserEmail = email;
		mUserPassword = password;
		mName = name;
		mAddress = address;
		mCreditCardInfo = creditCardInfo;
		mMobileNumber = mobNum;
		mAccountBalance = accountBalance;
		incID();
		connection = DBConnect.DBConnect();

		addAccount();
	}

	public void addAccount() {
		try {

			stmt = connection.createStatement();
			stmt.execute("insert into [User] (UserID,Email,Password) values ('" + mUserID + "','" + mUserEmail + "','"
					+ mUserPassword + "')");
			stmt.execute(
					"insert into customer  (UserID,CustomerName, Address,MobileNumber,AccountBalance,CreditCardinfo) values ('"
							+ mUserID + "','" + mName + "','" + mAddress + "','" + mMobileNumber + "','"
							+ mAccountBalance + "','" + mCreditCardInfo + "')");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error executing query");
			e.printStackTrace();
		}
	}

	public void buyProduct(String CCInfo, String myID, int Quantity) {
		Connection connection = DBConnect.DBConnect();
		try {
			ArrayList<Integer> balance = new ArrayList<Integer>();
			Statement stmt = connection.createStatement();
			ResultSet resultset_customer = stmt
					.executeQuery("Select AccountBalance from Customer where CreditCardInfo ='" + CCInfo + "'");
			while (resultset_customer.next()) {
				balance.add(resultset_customer.getInt(1));
			}

			ResultSet resultset = stmt
					.executeQuery("Select Quantity, ProductPrice from Product where ProductID ='" + myID + "'");
			while (resultset.next()) {
				if (resultset.getInt(1) < Quantity) {
					JOptionPane.showMessageDialog(null, "There aren't enough quantity.");
				} else if (resultset.getInt(2) > balance.get(0)) {
					JOptionPane.showMessageDialog(null, "You don't have enough money to buy this product.");
				} else {
					JOptionPane.showMessageDialog(null, "Your order has been placed successfully.");
					try {
						stmt = connection.createStatement();
						stmt.executeUpdate("update Product set Quantity='" + (resultset.getInt(1) - Quantity)
								+ "' where ProductID='" + myID + "'");
						stmt.executeUpdate("update Customer set AccountBalance='"
								+ (balance.get(0) - resultset.getInt(2)) + "' where CreditCardInfo ='" + CCInfo + "'");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
}
