package Item;

public interface ItemHandler {
	public float getmMinPrice();
	public void setmMinPrice(float mMinPrice);

	public float getmMaxPrice();
	public void setmMaxPrice(float mMaxPrice);
	
    public void addItem(float minPrice, float maxPrice);
    public boolean inRange(int num);
}
