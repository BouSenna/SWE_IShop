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
import java.util.List;
import Database.DBConnect;

import java.sql.SQLException;
import Database.DBConnect;

public class StoreOwner extends User implements StoreOwnerInterface{
	private String mName;
	private int mNumOfStores;
	private static int mLicense = 1;
	Connection mConnection = null;
	
	
	public StoreOwner(){
		mName = "";
		mNumOfStores = 0;
	}
	
	public void setName(String name) {this.mName = name;}
	public String getName() {return this.mName;}
	
	public void setnumOfStores(int num) {this.mNumOfStores = num;}
	public int getnumOfStores() {return this.mNumOfStores;}
	  
	public void register(String email, String password, String name) {
		mUserEmail = email;
		mUserPassword = password;
		mName = name;
		incID();
		mConnection = DBConnect.DBConnect();
		addAccount();
	}

	public void addAccount(){
		try {
			stmt = mConnection.createStatement();
			stmt.execute("insert into [User] (UserID, Email, Password) values ('"+mUserID+"','"+mUserEmail+"','"+mUserPassword+"')");
			stmt.execute("insert into StoreOwner  (OwnerName, NumberOfStores, License,  UserID ) values ('"+mName+"','"+mNumOfStores+"','"+mLicense+"','"+mUserID+"')");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error executing query");
			e.printStackTrace();
		}
	}
}
