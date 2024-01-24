package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;
import sql.connection.DBConnection;
public class UserDAO {
	
	public User getUserByUsernameAndPassword (String username, String password) throws SQLException {
		Connection connection = DBConnection.makeConnection(); 
		
		String sqlQuery = "SELECT * FROM user WHERE username = ? AND password = ?";
		PreparedStatement stmt = connection.prepareStatement(sqlQuery);
		
		stmt.setString(1, username);
		stmt.setString(2, password);
		
		ResultSet resultSet = stmt.executeQuery();

		if (resultSet.next()) {
			int id = resultSet.getInt("id");
			return new User(id, username, password);
		}
		return null ;
	}
}
