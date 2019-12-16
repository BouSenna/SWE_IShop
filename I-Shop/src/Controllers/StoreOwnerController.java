package Controllers;

import java.sql.SQLException;

import Database.DBConnect;
import Models.StoreOwnerModel;

///This class handles requests from users. it is responsible for rendering a response
///with the aid of the StoreOwnerView and StoreOwnerModel.
public class StoreOwnerController {
	public StoreOwnerController() {
	}

	/// Add store owner account.
	public void register(String UserEmail, String UserPassword, String Name) {
		new StoreOwnerModel().addStoreOwner(UserEmail, UserPassword, Name);
	}

}
