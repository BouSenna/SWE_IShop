package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DBConnect;

///This class is responsible for retrieving and updating the data from the Administrator table
///in the database and converting it to a meaningful concept for our software.
public class StoreModel {
	Connection connection = null;
	Statement stmt = null;
	ResultSet resultset = null;
	
	public StoreModel() {}
	
	/// Method that updates the approval of a store in the database. 
	public void updateApproval(String newValue, String myID) {
		try {
    		connection = DBConnect.DBConnect();
    		stmt = connection.createStatement();
			stmt.executeUpdate("update Store set Approval='"+newValue+"' where StoreID='"+myID+"'");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
