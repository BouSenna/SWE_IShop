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

public class Customer extends User implements CustomerInterface {
	    private String mName;
	    private String mAddress;
	    private String mCreditCardInfo;
	    private int mMobileNumber;
	    private float mAccountBalance;
	    Connection connection= null;
	    Statement stmt = null;
	  

    public Customer() {
    	mName = "";
        mAddress = "";
        mCreditCardInfo = "";
        mMobileNumber = 0;
        mAccountBalance = 0;
        
    }
    
    public void setName(String name) {this.mName = name;}
    public String getName() {return this.mName;}
    
    public void setAddress(String address) {this.mAddress = address;}
    public String getAddress() {return this.mAddress;}
    
    public void setCCInfo(String ccinfo) {this.mCreditCardInfo = ccinfo;}
    public String getCCInfo() {return this.mCreditCardInfo;}
    
    public void setMobNum(int num) {this.mMobileNumber = num;}
    public int getMobNum() {return this.mMobileNumber;}
    
    public void setAccBalance(float balance) {this.mAccountBalance = balance;}
    public float getAccBalance() {return this.mAccountBalance;}
    
    public void register(String email, String password, String name, String address,
                         String creditCardInfo, int mobNum, float accountBalance) {
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
    
    public void addAccount(){
    	try {
    		
			 stmt = connection.createStatement();
			 stmt.execute("insert into [User] (UserID,Email,Password) values ('"+mUserID+"','"+mUserEmail+"','"+mUserPassword+"')");
			 stmt.execute("insert into customer  (UserID,CustomerName, Address,MobileNumber,AccountBalance,CreditCardinfo) values ('"+mUserID+"','"+mName+"','"+mAddress+"','"+mMobileNumber+"','"+mAccountBalance+"','"+mCreditCardInfo+"')");
			 stmt.close();
		} catch (SQLException e) {
			System.out.println("Error executing query");
			e.printStackTrace();
		}
    }
}


