package Users;

public interface StoreOwnerInterface {
	 public void setName(String name);
	 public String getName();
	 
	 public void setnumOfStores(int num);
	 public int getnumOfStores();
	 
	 public void register(String email, String password, String name);
}
