package Item;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Database.DBConnect;
import Enums.Type;
import Enums.Category;

public class Item_Specs implements ItemSpecsHandler {
   String mName;
   String mCategory;
   
   Connection connection = null;
   Statement stmt = null;
   ResultSet resultset = null;

   public void setName(String name) {this.mName = name;}
   public String getName() {return this.mName;}
   
   public void setCategory(String cat) {this.mCategory = cat;}
   public String getCategory() {return this.mCategory;}
   
   public Item_Specs() {}
   public Item_Specs(String name, String category){
	   mName = name;
	   mCategory = category;
   }
	   
   public void addItemSpecs(String name, String category) {
	  try {
		  	  mName = name;
		  	  mCategory = category;
			  connection = DBConnect.DBConnect();
		      stmt = connection.createStatement();
		      stmt.execute("insert into itemspecs values ('"+mName+"','"+mCategory+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}   
  }
   
  public boolean matches(Item_Specs item) {
        try {
        	connection = DBConnect.DBConnect();
        	stmt = connection.createStatement();
            resultset = stmt.executeQuery("select ItemName, Category from ItemSpecs");
			while(resultset.next()) {
				if((resultset.getString(1).toUpperCase()).equals(item.mName.toUpperCase()) && 
						(resultset.getString(2).toUpperCase()).equals(item.mCategory.toUpperCase()))
				    return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
        return false;
    }
}