package Users;

import java.sql.SQLException;
import Database.DBConnect;

public interface CustomerInterface {
	public void setName(String name);
    public String getName();
    
    public void setAddress(String address);
    public String getAddress();
    
    public void setCCInfo(String ccinfo);
    public String getCCInfo();
    
    public void setMobNum(int num);
    public int getMobNum();
    
    public void setAccBalance(float balance);
    public float getAccBalance();
    
    public void register(String email, String password, String name, String address,
            String creditCardInfo, int mobNum, float accountBalance);
}
