package Users;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DBConnect;
import Enums.UserTypes;

public abstract class User {
    protected static int mUserID = 1;
    protected String mUserEmail;
    protected String mUserPassword;
    Connection connection= null;
    Statement stmt = null;
    ResultSet resultset = null;
    public void incID() {this.mUserID++;}
    
    public int login(String Email, String password) {
    	try {
    		connection = DBConnect.DBConnect();
        	stmt = connection.createStatement();
        	for (UserTypes type : UserTypes.values()) {
				ResultSet resultset = stmt.executeQuery("select email,password from [User] inner "
						+ "join "+type.myString()+" on [user].UserID="+type.myString()+".UserID");
				while(resultset.next()) {
					if(resultset.getString("email").equals(Email) && resultset.getString("password").equals(password) ) 
						return type.ordinal();
				}
        	}
    	} catch (SQLException e) {
			e.printStackTrace();
    	} 
    	return -1;
    }

}