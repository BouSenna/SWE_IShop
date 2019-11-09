package Users;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Database.DBConnect;

public class Admin extends User implements AdminInterface{
    private String mName;
    
    public Admin(String name){
        mName = name;
    }

    public void setName(String name) {this.mName = name;}
    public String getName() {return this.mName;}
 
}
