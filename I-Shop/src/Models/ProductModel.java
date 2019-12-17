package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Database.DBConnect;
import Statistics.Statistics;
import Statistics.QuantitySubject;

///This class is responsible for retrieving the data from the product table in the database and converting
///it to a meaningful concept for our software.
public class ProductModel  implements QuantitySubject {
	Connection connection = null;
	Statement stmt = null;
	ResultSet resultset = null;
	Statistics stat = new Statistics();

	private ArrayList<Statistics> observers = new ArrayList<Statistics>();

	public ProductModel() {
	}

	/// Method to return the available quantity of a product.
	public int getQuantity(String myID) {
		/// Establishing a connection with the database.
		connection = DBConnect.DBConnect();
		int quantity = -1;
		try {
			stmt = connection.createStatement();
			/// Getting the available quantity of the product with the given product ID
			/// and storing it in variable quantity
			resultset = stmt.executeQuery("Select Quantity from Product where ProductID ='" + myID + "'");
			while (resultset.next()) {
				quantity = resultset.getInt(1);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return quantity;
	}

	/// Method to return the price of a product from the database.
	public int getProductPrice(String myID) {
		/// Establishing a connection with the database.
		connection = DBConnect.DBConnect();
		int price = -1;
		try {
			stmt = connection.createStatement();
			/// Getting the price of the product with the given product ID
			/// and storing it in variable price
			ResultSet resultset = stmt.executeQuery("Select ProductPrice from Product where ProductID ='" + myID + "'");
			while (resultset.next()) {
				price = resultset.getInt(1);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return price;
	}

	/// Method that updates the quantity of a product in the database.
	public void updateQuantity(String myID, int Quantity) {
		/// Establishing a connection with the database.
		connection = DBConnect.DBConnect();
		try {
			/// Updating the quantity of the product -with the given product ID-
			/// with the new quantity.
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("update Product set Quantity='" + Quantity + "' where ProductID='" + myID + "'");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		registerObserver(stat);
		setChanged(myID, Quantity);
	}

	/// Method that adds new products to the database.
	public void addNewProduct(int Brand, int Item, int Store, int Price, String Name, int InitialQuantity,
			int CurrentQuantity) {
		try {
			connection = DBConnect.DBConnect();
			stmt = connection.createStatement();
			stmt.execute(
					"insert into product(ProductName, ProductPrice, StoreID, BrandID, ItemID, InitialQuantity, Quantity) values"
							+ " ('" + Name + "','" + Price + "', '" + Store + "', '" + Brand + "', '" + Item + "', '"
							+ InitialQuantity + "', '" + CurrentQuantity + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/// Method that removes a product from the database.
	public void removeProduct(int Store, String Name) {
		try {
			connection = DBConnect.DBConnect();
			stmt = connection.createStatement();
			stmt.execute("delete from product where ProductName ='" + Name + "' AND StoreID ='" + Store + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setChanged(String ID, int quantity) {
		notifyObserver(ID, quantity);
	}

	@Override
	public void registerObserver(Statistics stat) {
		observers.add(stat);

	}

	@Override
	public void removeObserver(Statistics stat) {
		int i = observers.indexOf(stat);
		if (i >= 0)
			observers.remove(i);

	}

	@Override
	public void notifyObserver(String ID, int quantity) {
		for (int i = 0; i < observers.size(); i++) {
			Statistics obs = observers.get(i);
			obs.update(ID, quantity);
		}

	}

}
