package Products;
import Brands.Brand;
import Item.Item;

public interface ProductHandler {
	public String getmName();
	public void setmName(String mName);

	public int getmPrice();
	public void setmPrice(int mPrice);

	public int getmStore();
	public void setmStore(int mStore);

	public int getmBrand();
	public void setmBrand(int mBrand);

	public int getmItem();
	public void setmItem(int mItem);

	public void addProduct(String name, int price, int store, int brand, int item);

}
