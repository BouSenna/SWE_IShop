package Item;

import java.sql.Connection;
import java.sql.Statement;

import Database.DBConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Item implements ItemHandler {
    private float mMinPrice;
    private float mMaxPrice;
    private Item_Specs mItemspecs;
    Connection connection= null;
    Statement stmt = null;

    public Item() {}
	public Item(float minPrice, float maxPrice, Item_Specs itemspecs){
        mMinPrice = minPrice;
        mMaxPrice = maxPrice;
        mItemspecs = itemspecs;
	}    
   
	public float getmMinPrice() {return mMinPrice;}
	public void setmMinPrice(float mMinPrice) {this.mMinPrice = mMinPrice;}

	public float getmMaxPrice() {return mMaxPrice;}
	public void setmMaxPrice(float mMaxPrice) {this.mMaxPrice = mMaxPrice;}
	
    public void addItem(float minPrice, float maxPrice) {
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
