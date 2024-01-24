package sql.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection makeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/be5-final-project", "newuser","Newuser123?");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	
}