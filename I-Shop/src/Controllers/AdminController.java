package Controllers;

import Models.StoreModel;

///This class handles requests from users. it is responsible for rendering a response
///with the aid of the AdminView and AdminModel.
public class AdminController {
	public AdminController(){}
	
	public void confirmStoreAddition(String newValue, String myID) {
    	new StoreModel().updateApproval(newValue, myID);
    }
}
