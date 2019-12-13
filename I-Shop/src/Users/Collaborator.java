package Users;

public class Collaborator extends User implements CollaboratorInterface {
	String mName;
	int mLicense;

	/// Constructor
	public Collaborator() {
	}

	public Collaborator(String Name, int License) {
		this.mLicense = License;
		this.mName = Name;
	}

	/// Mutators and accessors.
	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public int getmLicense() {
		return mLicense;
	}

	public void setmLicense(int mLicense) {
		this.mLicense = mLicense;
	}
}
