package Controllers;

import Models.ItemModel;

///This class handles requests from users, it is responsible for rendering a response
///with the aid of the ItemView and ItemController.
public class ItemController {
	public ItemController() {}
	
	public void addItem(int minPrice, int maxPrice) {
		new ItemModel().addItem(minPrice, maxPrice);
	}
}
