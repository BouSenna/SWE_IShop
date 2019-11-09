package Brands;
import java.sql.SQLException;
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

import Database.DBConnect;
import Enums.Category;

public class Brand implements BrandInterface {
	private String mBrandName;
	private String mCategory;
	
	private Connection connection;
    private Statement stmt = null;

	public void setName(String name) {this.mBrandName = name;}
    public String getName() {return this.mBrandName;}
    
    public void setCategory(String cat) {this.mCategory = cat;}
    public String getCategory() {return this.mCategory;}
    
    public void addBrand(String Name, String Category) {
        connection = DBConnect.DBConnect();
        this.mBrandName = Name;
        this.mCategory = Category;
        try {
			 stmt = connection.createStatement();
			 stmt.execute("insert into Brand (BrandName, Category) values ('"+mBrandName+"','"+mCategory+"')");
			 stmt.close();
		} catch (SQLException e) {
			System.out.println("Error executing query");
			e.printStackTrace();
		}
    }
    
   public boolean matches(Brand brand) {
	   try {
		    ResultSet resultset = null;
       		connection = DBConnect.DBConnect();
       		stmt = connection.createStatement();
            resultset = stmt.executeQuery("select BrandName, Category from Brand");
            while(resultset.next()) {
				if((resultset.getString(1).toUpperCase()).equals(brand.mBrandName.toUpperCase()) && 
						(resultset.getString(2).toUpperCase()).equals(brand.mCategory.toUpperCase()))
				    return true;
            }
            
	   } catch (SQLException e) {
			e.printStackTrace();
	   }
       return false;
   }
}
