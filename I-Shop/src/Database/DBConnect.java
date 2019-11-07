package Database;
import java.sql.*;

public class DBConnect {

	Connection connection= null;
	public static Connection DBConnect() {
		try {
			String url = "jdbc:sqlserver://localhost;databaseName=OnlineStoreDatabase;integratedSecurity=true;";
			Connection connection = DriverManager.getConnection(url);
			Statement stmt = connection.createStatement();
			return connection;
            
        } catch(SQLException e1) {
            System.out.println("Error connecting database");
            return null;
        }
	
	}
}
