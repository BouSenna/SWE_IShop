package Item;

import java.sql.SQLException;
import Database.DBConnect;

public interface ItemSpecsHandler {
	public void setName(String name);
    public String getName();
    
    public void setCategory(String cat);
    public String getCategory();
    
	public void addItemSpecs(String name, String category);
	public boolean matches(Item_Specs item);
}
