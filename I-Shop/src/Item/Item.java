package Item;

public class Item implements ItemHandler {
	private int mMinPrice;
	private int mMaxPrice;
	private Item_Specs mItemspecs;

	public Item() {
	}

	public Item(int minPrice, int maxPrice, Item_Specs itemspecs) {
		mMinPrice = minPrice;
		mMaxPrice = maxPrice;
		mItemspecs = itemspecs;
	}

	public int getmMinPrice() {
		return mMinPrice;
	}

	public void setmMinPrice(int mMinPrice) {
		this.mMinPrice = mMinPrice;
	}

	public int getmMaxPrice() {
		return mMaxPrice;
	}

	public void setmMaxPrice(int mMaxPrice) {
		this.mMaxPrice = mMaxPrice;
	}
}
