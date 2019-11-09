package Products;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Brands.Brand;
import Database.DBConnect;
import Item.Item;

public class Product implements ProductHandler {
	private String mName;
	private int mPrice;
	private int mStore;
	private int mBrand;
	private int mItem;
	private int mInitialQuantity;
	private int mCurrentQuantity;
	
	Connection connection= null;
    Statement stmt = null;

	
	public Product() {}
	public Product(int price, int item, int brand, int store, String name) {
		this.mBrand = brand;
		this.mItem = item;
		this.mStore = store;
		this.mPrice = price;
		this.mName = name;
	}
	
	public String getmName() {return mName;}
	public void setmName(String mName) {this.mName = mName;}

	public int getmPrice() {return mPrice;}
	public void setmPrice(int mPrice) {this.mPrice = mPrice;}

	public int getmStore() {return mStore;}
	public void setmStore(int mStore) {this.mStore = mStore;}

	public int getmBrand() {return mBrand;}
	public void setmBrand(int mBrand) {this.mBrand = mBrand;}

	public int getmItem() {return mItem;}
	public void setmItem(int mItem) {this.mItem = mItem;}
 
	public void addProduct(String name, int price, int store, int brand, int item, int quantity) {
		try {
			this.mBrand = brand;
			this.mItem = item;
			this.mStore = store;
			this.mPrice = price;
			this.mName = name;
			this.mInitialQuantity = quantity;
			this.mCurrentQuantity = quantity;
		    connection = DBConnect.DBConnect();
	        stmt = connection.createStatement();
	        stmt.execute("insert into product(ProductName, ProductPrice, StoreID, BrandID, ItemID, InitialQuantity, Quantity) values"
	        		+ " ('"+mName+"','"+mPrice+"', '"+mStore+"', '"+mBrand+"', '"+mItem+"', '"+mInitialQuantity+"', '"+mCurrentQuantity+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}   
	
	}
}
