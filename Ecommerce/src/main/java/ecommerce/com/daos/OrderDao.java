package ecommerce.com.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				pro.setOrder_date(resultSet.getDate("order_date"));
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
					.prepareStatement("INSERT INTO orders(user_id, order_status) VALUES(?,?)");
			statement.setInt(1, pro.getUser_id());
			statement.setString(2, pro.getOrder_status());
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
				pro.setOrder_date(resultSet.getDate("order_date"));
				pro.setOrder_status(resultSet.getString("order_status"));
				;
			}
		} finally {
			DatabaseConnection.closeConnection();
		}
		return pro;
	}

}