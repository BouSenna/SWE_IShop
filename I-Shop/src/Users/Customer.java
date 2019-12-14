package Users;

import Models.CustomerModel;

public class Customer extends User implements CustomerInterface {
	private String mName;
	private String mAddress;
	private String mCreditCardInfo;
	private int mMobileNumber;
	private float mAccountBalance;

	/// Constructor
	public Customer() {
		mName = "";
		mAddress = "";
		mCreditCardInfo = "";
		mMobileNumber = 0;
		mAccountBalance = 0;

	}

	/// Accessors and Mutators
	public void setName(String name) {
		this.mName = name;
	}

	public String getName() {
		return this.mName;
	}

	public void setAddress(String address) {
		this.mAddress = address;
	}

	public String getAddress() {
		return this.mAddress;
	}

	public void setCCInfo(String ccinfo) {
		this.mCreditCardInfo = ccinfo;
	}

	public String getCCInfo() {
		return this.mCreditCardInfo;
	}

	public void setMobNum(int num) {
		this.mMobileNumber = num;
	}

	public int getMobNum() {
		return this.mMobileNumber;
	}

	public void setAccBalance(float balance) {
		this.mAccountBalance = balance;
	}

	public float getAccBalance() {
		return this.mAccountBalance;
	}

	/// Registration method
	public void register(String email, String password, String name, String address, String creditCardInfo, int mobNum,
			float accountBalance) {
		mUserEmail = email;
		mUserPassword = password;
		mName = name;
		mAddress = address;
		mCreditCardInfo = creditCardInfo;
		mMobileNumber = mobNum;
		mAccountBalance = accountBalance;
		incID();

		new CustomerModel().addNewCustomer(mUserEmail, mUserPassword, mName, mAddress, mCreditCardInfo, mMobileNumber,
				mAccountBalance);
	}
}
