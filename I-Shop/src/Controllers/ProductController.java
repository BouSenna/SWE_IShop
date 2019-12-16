package Controllers;

import Forms.DisplayMessages;
import Models.BrandModel;
import Models.ItemSpecsModel;
import Models.ProductModel;

//This class handles requests from users, it is responsible for rendering a response
///with the aid of the ProductView and ProductController.
public class ProductController {
	public ProductController() {

	}

	/// Adding new product to the database given the brand and item name.
	public void addProduct(String name, int price, int store, String brandName, String itemName, int quantity) {
		/// Getting the ID if both the brand and the item.
		int BrandID = new BrandModel().getBrandID(brandName);
		int ItemID = new ItemSpecsModel().getItemID(itemName);

		/// Adding the new product to the DB.
		addProduct(name, price, store, BrandID, ItemID, quantity);
	}

	/// Adding new product to the database
	public void addProduct(String name, int price, int store, int brand, int item, int quantity) {
		/// Adding the new product to the DB.
		new ProductModel().addNewProduct(brand, item, store, price, name, quantity, quantity);

		/// Sending verification message.
		new DisplayMessages().displayMessage("Product added successfully to your store.");
	}
}
