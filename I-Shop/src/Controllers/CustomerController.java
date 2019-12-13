package Controllers;

import Forms.DisplayMessages;
import Models.CustomerModel;
import Models.ProductModel;

///This class handles requests from users. it is responsible for rendering a response
///with the aid of the customerView and customerModel.
public class CustomerController {
	public void buyProduct(String CCInfo, String myID, int Quantity) {
		/// Getting the balance of the customer.
		int mBalance = new CustomerModel().getBalance(CCInfo);
		/// Getting the available quantity of the product in the store.
		int mQuantity = new ProductModel().getQuantity(myID);
		/// Getting the price of the product.
		int mProductPrice = new ProductModel().getProductPrice(myID);

		/// Checking whether the needed quantity is less than the available quantity or
		/// not.
		if (mQuantity < Quantity) {
			new DisplayMessages().displayMessage("There aren't enough quantity.");
		}
		/// Checking whether the product price is less the account balance of the
		/// customer.
		else if (mProductPrice > mBalance) {
			new DisplayMessages().displayMessage("You don't have enough money to buy this product.");

		}
		/// Sending verification message to the customer.
		else {
			new DisplayMessages().displayMessage("Your order has been placed successfully.");
			new ProductModel().updateQuantity(myID, mQuantity - Quantity);
			new CustomerModel().updateBalance(CCInfo, mBalance - mProductPrice);

		}
	}
}
