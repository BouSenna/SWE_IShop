package Brands;

public class Brand implements BrandInterface {
	private String mBrandName;
	private String mCategory;

	///Mutators and accessors.
	public void setName(String name) {this.mBrandName = name;}
    public String getName() {return this.mBrandName;}
    
    public void setCategory(String cat) {this.mCategory = cat;}
    public String getCategory() {return this.mCategory;}
}
