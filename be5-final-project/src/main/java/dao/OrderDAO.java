package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sql.connection.DBConnection;

public class OrderDAO {
	public void addOrderInfo(int userId) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		PreparedStatement preStmt = null;

		String sqlQuery = "INSERT INTO `order` (user_id, submit_date) VALUES (?, NOW());";
		preStmt = connection.prepareStatement(sqlQuery);
		preStmt.setInt(1, userId);

		preStmt.executeUpdate();
	}
	
	public void addOrderDetail(int orderId, int productId, int quantity, int price) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		PreparedStatement preStmt = null;
				
		String sqlQuery = "INSERT INTO `order-detail` (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?);";
		preStmt = connection.prepareStatement(sqlQuery);
		
		preStmt.setInt(1, orderId);
		preStmt.setInt(2, productId);
		preStmt.setInt(3, quantity);
		preStmt.setInt(4, price);
		
		preStmt.executeUpdate();
	}
	
	public int getLastOrderIdByUserId(int userId) throws SQLException {
		Connection connection = DBConnection.makeConnection();
		PreparedStatement preStmt = null;
		
		String sqlQuery = "SELECT * FROM `order` WHERE (`user_id` ="
				+ String.valueOf(userId)
				+ ") AND (submit_date = (SELECT MAX(`submit_date`) from `order` WHERE `user_id` ="
				+ String.valueOf(userId)
				+ "));";
		preStmt = connection.prepareStatement(sqlQuery);
		
		//preStmt.setInt(1, userId);
		//preStmt.setInt(2, userId);
		
		
		ResultSet resultSet = preStmt.executeQuery(sqlQuery);
		
		if (resultSet.next()) {
			return (resultSet.getInt("id"));
		}
		return -1;
	}
}
