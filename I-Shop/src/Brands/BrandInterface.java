package Brands;

import Enums.Category;

public interface BrandInterface {
	public void setName(String name);
    public String getName();
    
    public void setCategory(String cat);
    public String getCategory();
    
    public void addBrand(String Name, String Category);
}
