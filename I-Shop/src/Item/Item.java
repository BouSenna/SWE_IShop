package Item;

import java.sql.Connection;
import java.sql.Statement;

import Database.DBConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Item implements ItemHandler {
    private int mMinPrice;
    private int mMaxPrice;
    private Item_Specs mItemspecs;
    Connection connection= null;
    Statement stmt = null;

    public Item() {}
	public Item(int minPrice, int maxPrice, Item_Specs itemspecs){
        mMinPrice = minPrice;
        mMaxPrice = maxPrice;
        mItemspecs = itemspecs;
	}    
   
	public int getmMinPrice() {return mMinPrice;}
	public void setmMinPrice(int mMinPrice) {this.mMinPrice = mMinPrice;}

	public int getmMaxPrice() {return mMaxPrice;}
	public void setmMaxPrice(int mMaxPrice) {this.mMaxPrice = mMaxPrice;}
	
    public void addItem(int minPrice, int maxPrice) {
    	mMaxPrice = maxPrice;
    	mMinPrice = minPrice;
    	connection = DBConnect.DBConnect();
    	try {
			stmt=connection.createStatement();
			stmt.execute("insert into items (MaxPrice, MinPrice) values ('"+mMaxPrice+"','"+mMinPrice+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public boolean inRange(int num) {
    	if (num >= this.mMinPrice && num <= this.mMaxPrice)
    		return true;
    	return false;
    }
}
