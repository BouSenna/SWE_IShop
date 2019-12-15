package Controllers;

import Models.ItemModel;

///This class handles requests from users, it is responsible for rendering a response
///with the aid of the ItemView and ItemController.
public class ItemController {
	public ItemController() {}
	
	///Method to add item.
	public void addItem(int minPrice, int maxPrice) {
		new ItemModel().addItem(minPrice, maxPrice);
	}
	
	///Method to check whether the price is valid or not.
	public boolean checkPrice(int price, int ID) {
		return new ItemModel().inRange(price, ID);
	}
}
