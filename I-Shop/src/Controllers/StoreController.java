package Controllers;

import Models.StoreModel;

///This class handles requests from users, it is responsible for rendering a response
///with the aid of the StoreView and StoreModel.
public class StoreController {
	///Constructor
	public void StoreController(){}
	
	public void addStore(String StoreName, String Category, String StoreType, String Address, int license) {
		new StoreModel().addStore(StoreName, Category, StoreType, Address, license);
	}
}
