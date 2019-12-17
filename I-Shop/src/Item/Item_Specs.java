package Item;

public class Item_Specs implements ItemSpecsHandler {
	String mName;
	String mCategory;

	/// Constructor
	public Item_Specs() {
	}

	public Item_Specs(String name, String category) {
		mName = name;
		mCategory = category;
	}

	/// Mutators and accessors
	public void setName(String name) {
		this.mName = name;
	}

	public String getName() {
		return this.mName;
	}

	public void setCategory(String cat) {
		this.mCategory = cat;
	}

	public String getCategory() {
		return this.mCategory;
	}
}