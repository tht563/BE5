package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Category;
import sql.connection.DBConnection;

public class CategoryDAO {
	public List<Category> getCategories() throws SQLException {
		
		Connection connection = DBConnection.makeConnection();
		Statement stmt = connection.createStatement();
		String sqlQuery = "SELECT * FROM category ORDER BY priority;";
		ResultSet resultSet = stmt.executeQuery(sqlQuery);
		List<Category> categories = new ArrayList<Category>();
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int priority = resultSet.getInt("priority");
			categories.add(new Category(id,name,priority));
		}
		return categories;
	}
	
	public String getCategoryById (String id) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		Statement stmt = connection.createStatement();
		String sqlQuery = "SELECT name FROM category WHERE id = " + id +";";
		ResultSet resultSet = stmt.executeQuery(sqlQuery);
		if (resultSet.next()) {
			return (resultSet.getString("name"));
		}
		return null;
	}
}	
