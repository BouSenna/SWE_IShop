package Products;

import Forms.DisplayMessages;
import Models.BrandModel;
import Models.ItemModel;
import Models.ProductModel;

public class Product implements ProductHandler {
	private String mName;
	private int mPrice;
	private int mStore;
	private int mBrand;
	private int mItem;
	private int mInitialQuantity;
	private int mCurrentQuantity;

	/// Constructor
	public Product() {
	}

	public Product(int price, int item, int brand, int store, String name) {
		this.mBrand = brand;
		this.mItem = item;
		this.mStore = store;
		this.mPrice = price;
		this.mName = name;
	}

	/// Mutators and accessors.
	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public int getmPrice() {
		return mPrice;
	}

	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}

	public int getmStore() {
		return mStore;
	}

	public void setmStore(int mStore) {
		this.mStore = mStore;
	}

	public int getmBrand() {
		return mBrand;
	}

	public void setmBrand(int mBrand) {
		this.mBrand = mBrand;
	}

	public int getmItem() {
		return mItem;
	}

	public void setmItem(int mItem) {
		this.mItem = mItem;
	}

	/// Adding new product to the database given the brand and item name.
	public void addProduct(String name, int price, int store, String brandName, String itemName, int quantity) {
		/// Getting the ID if both the brand and the item.
		int BrandID = new BrandModel().getBrandID(brandName);
		int ItemID = new ItemModel().getItemID(itemName);

		/// Adding the new product to the DB.
		new Product().addProduct(name, price, store, BrandID, ItemID, quantity);
	}

	/// Adding new product to the database
	public void addProduct(String name, int price, int store, int brand, int item, int quantity) {
		this.mBrand = brand;
		this.mItem = item;
		this.mStore = store;
		this.mPrice = price;
		this.mName = name;
		this.mInitialQuantity = quantity;
		this.mCurrentQuantity = quantity;

		/// Adding the new product to the DB.
		new ProductModel().addNewProduct(this.mBrand, this.mItem, this.mStore, this.mPrice, this.mName,
				this.mInitialQuantity, this.mCurrentQuantity);
		
		/// Sending verification message.
		new DisplayMessages().displayMessage("Product added successfully to your store.");
	}
}
