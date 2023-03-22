package documentary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSQL {
    String url = "jdbc:mysql://localhost:3306/document";// your db name
    String user="root"; // your db username
    String password="root"; // your db password
    public Connection conn;
	public ConnectSQL() throws ClassNotFoundException,SQLException,NullPointerException{
		Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
	}


}
