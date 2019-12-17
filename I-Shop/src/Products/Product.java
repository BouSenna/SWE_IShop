package Products;

import Forms.DisplayMessages;
import Models.BrandModel;
import Models.ItemSpecsModel;
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
}
