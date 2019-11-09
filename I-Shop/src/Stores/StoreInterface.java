package Stores;

public interface StoreInterface {
	public void setName(String name);
    public String getName();
    
    public void setType(String type);
    public String getType();
    
    public void setCategory(String cat);
    public String getCategory();
    
    public void setAddress(String address);
    public String getAddress();
    
    public String getmApproval();
	public void setmApproval(String mApproval);
    
    public void addStore(String Name, String Category, String Type, String address, int license);
}
