package ecommerce.com.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ecommerce.com.models.Order;
import ecommerce.com.utils.DatabaseConnection;

public class OrderDao {
	public static List<Order> getAllOrder() throws SQLException {
		List<Order> pros = new ArrayList<Order>();
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Order pro = new Order();
				pro.setOrder_id(resultSet.getInt("order_id"));
				pro.setUser_id(resultSet.getInt("user_id"));
				Timestamp orderDateTime = resultSet.getTimestamp("order_date");
				pro.setOrder_date(orderDateTime);
				pro.setOrder_status(resultSet.getString("order_status"));
				pros.add(pro);
			}
		} finally {
			DatabaseConnection.closeConnection();
		}
		return pros;
	}

	public static void addOrder(Order pro) throws SQLException {
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO orders(user_id) VALUES(?)");
			statement.setInt(1, pro.getUser_id());
			statement.executeUpdate();
		} finally {
			DatabaseConnection.closeConnection();
		}
	}

	public static void deleteOrderById(int OrderId) throws SQLException {
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?");
			statement.setInt(1, OrderId);
			statement.executeUpdate();
		} finally {
			DatabaseConnection.closeConnection();
		}
	}

	public static void updateOrder(Order pro) throws SQLException {
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE orders SET user_id = ?, order_date = ?, order_status = ?,  WHERE order_id = ?");

			statement.setInt(1, pro.getUser_id());
			statement.setDate(2, (Date) pro.getOrder_date());
			statement.setString(3, pro.getOrder_status());
			statement.setInt(4, pro.getOrder_id());
			statement.executeUpdate();
		} finally {
			DatabaseConnection.closeConnection();

		}

	}

	public static Order getOrderById(int OrderId) throws SQLException {
		Order pro = null;
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE Order_id = ?");
			statement.setInt(1, OrderId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				pro = new Order();
				pro.setOrder_id(resultSet.getInt("order_id"));
				pro.setUser_id(resultSet.getInt("user_id"));
				Timestamp orderDateTime = resultSet.getTimestamp("order_date");
				pro.setOrder_date(orderDateTime);
				pro.setOrder_status(resultSet.getString("order_status"));
				;
			}
		} finally {
			DatabaseConnection.closeConnection();
		}
		return pro;
	}
	 public static Order getNewestOrderByUserId(int userId) throws SQLException {
	        Order order = null;
	        try {
	            Connection connection = DatabaseConnection.getConnection();
	            PreparedStatement statement = connection.prepareStatement(
	                "SELECT * FROM orders WHERE user_id = ? ORDER BY order_date DESC LIMIT 1");
	            statement.setInt(1, userId);
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                order = new Order();
	                order.setOrder_id(resultSet.getInt("order_id"));
	                order.setUser_id(resultSet.getInt("user_id"));
	                order.setOrder_date(resultSet.getDate("order_date"));
	                order.setOrder_status(resultSet.getString("order_status"));
	            }
	        } finally {
	            DatabaseConnection.closeConnection();
	        }
	        return order;
	    }
	 public static List<Order> getAllOrderByUserID(int userID) throws SQLException {
		    List<Order> orders = new ArrayList<>();
		    try {
		        Connection connection = DatabaseConnection.getConnection();
		        PreparedStatement statement = connection.prepareStatement(
		            "SELECT * FROM orders WHERE user_id = ? ORDER BY order_date ASC"
		        );
		        statement.setInt(1, userID);
		        ResultSet resultSet = statement.executeQuery();

		        while (resultSet.next()) {
		            Order order = new Order();
		            order.setOrder_id(resultSet.getInt("order_id"));
		            order.setUser_id(resultSet.getInt("user_id"));
					Timestamp orderDateTime = resultSet.getTimestamp("order_date");
					order.setOrder_date(orderDateTime);
					order.setOrder_status(resultSet.getString("order_status"));

		            orders.add(order);
		        }
		    } finally {
		        DatabaseConnection.closeConnection();
		    }
		    return orders;
		}



}