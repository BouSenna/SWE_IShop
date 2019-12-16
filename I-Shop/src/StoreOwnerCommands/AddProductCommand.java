package StoreOwnerCommands;

import Controllers.ProductController;

public class AddProductCommand implements IStoreOwnerCommand {
	String mName;
	int mPrice;
	int mStoreID;
	String mBrandName;
	String mItemName;
	int mQuantity;

	public AddProductCommand(String Name, int Price, int StoreID, String BrandName, String ItemName, int Quantity) {
		this.mName = Name;
		this.mPrice = Price;
		this.mStoreID = StoreID;
		this.mBrandName = BrandName;
		this.mItemName = ItemName;
		this.mQuantity = Quantity;
	}

	@Override
	public void execute() {
		new ProductController().addProduct(mName, mPrice, mStoreID, mBrandName, mItemName, mQuantity);
	}

	@Override
	public void undo() {
		new ProductController().removeProduct(mStoreID, mName);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
