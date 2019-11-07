package Stores;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DBConnect;

public class Store implements StoreInterface{
	private String mStoreName;
	private String mStoreType;
	private String mAddress;
	private String mCategory;
	private int mOwnerLicense;
	
	private Connection connection;
    private Statement stmt = null;

	public void setName(String name) {this.mStoreName = name;}
    public String getName() {return this.mStoreName;}
    
    public void setType(String type) {this.mStoreType = type;}
    public String getType() {return this.mStoreType;}
    
    public void setCategory(String cat) {this.mCategory = cat;}
    public String getCategory() {return this.mCategory;}
    
    public void setAddress(String address) {this.mAddress = address;}
    public String getAddress() {return this.mAddress;}
    
    public void addStore(String Name, String Category, String Type, String address, int license) {
        connection = DBConnect.DBConnect();
        this.mStoreName = Name;
        this.mCategory = Category;
        this.mAddress = address;
        this.mStoreType = Type;
        this.mOwnerLicense = license;
        try {
			 stmt = connection.createStatement();
			 stmt.execute("insert into Store (License, StoreName, StoreType, Address, Category) values"
			 		+ " ('"+mOwnerLicense+"','"+mStoreName+"','"+mStoreType+"','"+mAddress+"','"+mCategory+"')");
		} catch (SQLException e) {
			System.out.println("Error executing query");
			e.printStackTrace();
		}

    }
}
