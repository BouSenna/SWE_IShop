package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;

import Database.DBConnect;
import Forms.ViewStatistics;
import net.proteanit.sql.DbUtils;

public class StatisticsModel {// more stats in each store yes,no in admin -->add stat in stores
	
	public void getStatistics(int storeID) {
		try {
			Connection connection;
		    Statement stmt = null;
		    ResultSet resultset = null;
		    ArrayList<String> output =new ArrayList<>();
		    int size = 0;
       		connection = DBConnect.DBConnect();
       		stmt = connection.createStatement();
            resultset = stmt.executeQuery("select ProductName, InitialQuantity, Quantity from Product where StoreID = '"+storeID+"' ");
            while(resultset.next()) {
				if (resultset.getInt(2) - resultset.getInt(3) != resultset.getInt(2))
					output.add(resultset.getString(1) +"			"+Integer.toString(resultset.getInt(2)-resultset.getInt(3))+"\n"); 
				else 
					output.add(resultset.getString(1) +"			"+"Sold out \n"); 
				
				size++;
            }
            
            new ViewStatistics().appendOutput(output, size); 
		} catch (SQLException e) {
			e.printStackTrace();
	   }
	}
	
	public void updateStatistics(String ID, int quantity) {
		Connection connection = DBConnect.DBConnect();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("update Product set Quantity='" + quantity + "' where ProductID='" + ID + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ResultSet showStatistics(String selectedOp, String selected) {
		Connection connection = DBConnect.DBConnect(); 
		String query="";
		try {
			Statement stmt1 = connection.createStatement();
			if(selectedOp.equals("Best seller")) {
				query = "select " +selected+"name, (initialquantity-quantity) as RemainingQuantity from product inner join brand on product.brandid = brand.brandid  order by RemainingQuantity asc";
			
			}
			else if(selectedOp.equals("Lowest seller")){
				query =  "select " +selected+"name, (initialquantity-quantity) as RemainingQuantity from product inner join brand on product.brandid = brand.brandid order by RemainingQuantity desc";
			}
			else {
				query = "select count(*) from " + selected;
			}
			Statement stmt = connection.createStatement();
			stmt.setMaxRows(1);
			ResultSet resultset = stmt.executeQuery(query);
			
			return resultset;
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
}
