package Item;

public interface ItemHandler {
	public int getmMinPrice();
	public void setmMinPrice(int mMinPrice);

	public int getmMaxPrice();
	public void setmMaxPrice(int mMaxPrice);
	
    public void addItem(int minPrice, int maxPrice);
    public boolean inRange(int num);
}
