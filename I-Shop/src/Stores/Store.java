package Stores;

public class Store implements StoreInterface {
	private String mStoreName;
	private String mStoreType;
	private String mAddress;
	private String mCategory;
	private String mApproval;
	private int mOwnerLicense;

	/// Accessors and Mutators
	public String getmApproval() {
		return mApproval;
	}

	public void setmApproval(String mApproval) {
		this.mApproval = mApproval;
	}

	public void setName(String name) {
		this.mStoreName = name;
	}

	public String getName() {
		return this.mStoreName;
	}

	public void setType(String type) {
		this.mStoreType = type;
	}

	public String getType() {
		return this.mStoreType;
	}

	public void setCategory(String cat) {
		this.mCategory = cat;
	}

	public String getCategory() {
		return this.mCategory;
	}

	public void setAddress(String address) {
		this.mAddress = address;
	}

	public String getAddress() {
		return this.mAddress;
	}

}