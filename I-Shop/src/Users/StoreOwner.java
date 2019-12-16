package Users;

import Controllers.StoreOwnerController;

public class StoreOwner extends User implements StoreOwnerInterface {
	private String mName;
	private int mNumOfStores;
	private static int mLicense = 1;

	/// Constructor
	public StoreOwner() {
		mName = "";
		mNumOfStores = 0;
	}

	/// Mutators and accessors
	public void setName(String name) {
		this.mName = name;
	}

	public String getName() {
		return this.mName;
	}

	public void setnumOfStores(int num) {
		this.mNumOfStores = num;
	}

	public int getnumOfStores() {
		return this.mNumOfStores;
	}

	/// Method for the registeration process of the store owner.
	public void register(String email, String password, String name) {
		mUserEmail = email;
		mUserPassword = password;
		mName = name;
		new StoreOwnerController().register( mUserEmail, mUserPassword, mName);
		;
	}
}
