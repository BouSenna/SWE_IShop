package Users;

import Enums.UserTypes;
import Models.UserModel;

public abstract class User {
    protected static int mUserID = 1;
    protected String mUserEmail;
    protected String mUserPassword;
    
    public void incID() {this.mUserID++;}
    
    public int login(String Email, String password) {
    	return (new UserModel().checkLoginInfo(Email, password));
    }

}