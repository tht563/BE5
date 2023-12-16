package Database;
import java.sql.*;
public class DBConnection {
	public static Connection makeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_be5","newuser","newPassword1?");
			return conn;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}


