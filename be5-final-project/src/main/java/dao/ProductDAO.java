package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import sql.connection.DBConnection;

public class ProductDAO {
	public List <Product> getLastestProducts() throws SQLException{
		Connection connection = DBConnection.makeConnection();
		Statement stmt = connection.createStatement();
		String sqlQuery = "SELECT * FROM product WHERE is_new = 1";
		ResultSet resultSet = stmt.executeQuery(sqlQuery);
		List<Product> products = new ArrayList<Product>();
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int price = resultSet.getInt("price");
			String imgName = resultSet.getString("img_name");
			boolean is_new = resultSet.getBoolean("is_new");
			int quantity = resultSet.getInt("quantity");
			String description = resultSet.getString("description");
			products.add(new Product(id, name, price, imgName, is_new, quantity, description));
		}
		return products;
	}
	
	public Product getProductById (String productId) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		Statement stmt = connection.createStatement();
		String sqlQuery = "SELECT * FROM product WHERE product.id = "+productId+";";
		ResultSet resultSet = stmt.executeQuery(sqlQuery);
		Product product = new Product();
		if (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int price = resultSet.getInt("price");
			String imgName = resultSet.getString("img_name");
			boolean is_new = resultSet.getBoolean("is_new");
			int quantity = resultSet.getInt("quantity");
			String description = resultSet.getString("description");
			product = new Product(id, name, price, imgName, is_new, quantity, description);
		}	
		
		return product;
	}
	
	public List <Product> getAllProducts() throws SQLException{
		Connection connection = DBConnection.makeConnection();
		Statement stmt = connection.createStatement();
		String sqlQuery = "SELECT * FROM product";
		ResultSet resultSet = stmt.executeQuery(sqlQuery);
		List<Product> products = new ArrayList<Product>();
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int price = resultSet.getInt("price");
			String imgName = resultSet.getString("img_name");
			boolean is_new = resultSet.getBoolean("is_new");
			int quantity = resultSet.getInt("quantity");
			String description = resultSet.getString("description");
			products.add(new Product(id, name, price, imgName, is_new, quantity, description));
		}
		return products;
	}
}