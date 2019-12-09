package Users;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Database.DBConnect;

public class Admin extends User implements AdminInterface{
    private String mName;
    
    public Admin() {}
    public Admin(String name){
        mName = name;
    }

    public void setName(String name) {this.mName = name;}
    public String getName() {return this.mName;}
 
    public void confirmStoreAddition(String newValue, String myID) {
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
