package ecommerce.com.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecommerce.com.models.OrderDetail;
import ecommerce.com.utils.DatabaseConnection;

public class OrderDetailDao {
	public static List<OrderDetail> getAllOrderDetail() throws SQLException {
		List<OrderDetail> pros = new ArrayList<OrderDetail>();
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM orderdetails");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				OrderDetail pro = new OrderDetail();
				pro.setOrder_detail_id(resultSet.getInt("order_detail_id"));
				pro.setOrder_id(resultSet.getInt("order_id"));
				pro.setProduct_id(resultSet.getInt("product_id"));
				pro.setQuantity(resultSet.getInt("quantity"));

				pros.add(pro);
			}
		} finally {
			DatabaseConnection.closeConnection();
		}
		return pros;
	}

	public static void addOrderDetail(OrderDetail pro) throws SQLException {
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO orderdetails(order_id, product_id, quantity) VALUES(?,?,?)");
			statement.setInt(1, pro.getOrder_id());
			statement.setInt(2, pro.getProduct_id());
			statement.setInt(3, pro.getQuantity());

			statement.executeUpdate();
		} finally {
			DatabaseConnection.closeConnection();
		}
	}

	public static void deleteOrderDetailById(int OrderDetailId) throws SQLException {
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("DELETE FROM orderdetails WHERE order_detail_id = ?");
			statement.setInt(1, OrderDetailId);
			statement.executeUpdate();
		} finally {
			DatabaseConnection.closeConnection();
		}
	}

	public static void updateOrderDetail(OrderDetail pro) throws SQLException {
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE orderdetails SET order_id = ?, product_id = ?, quantity = ? WHERE order_detail_id = ?");
			statement.setInt(1, pro.getOrder_id());
			statement.setInt(2, pro.getProduct_id());
			statement.setInt(3, pro.getQuantity());
			statement.setInt(3, pro.getOrder_detail_id());
			statement.executeUpdate();
		} finally {
			DatabaseConnection.closeConnection();

		}

	}

	public static OrderDetail getOrderDetailById(int OrderDetailId) throws SQLException {
		OrderDetail pro = null;
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM orderdetails WHERE order_detail_id = ?");
			statement.setInt(1, OrderDetailId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				pro = new OrderDetail();
				pro.setOrder_detail_id(resultSet.getInt("order_detail_id"));
				pro.setOrder_id(resultSet.getInt("order_id"));
				pro.setProduct_id(resultSet.getInt("product_id"));
				pro.setQuantity(resultSet.getInt("quantity"));
			}
		} finally {
			DatabaseConnection.closeConnection();
		}
		return pro;
	}

	public static List<OrderDetail> getOrderDetailByOrderId(int orderId) throws SQLException {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM orderdetails WHERE order_id = ?");
			statement.setInt(1, orderId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrder_detail_id(resultSet.getInt("order_detail_id"));
				orderDetail.setOrder_id(resultSet.getInt("order_id"));
				orderDetail.setProduct_id(resultSet.getInt("product_id"));
				orderDetail.setQuantity(resultSet.getInt("quantity"));

				orderDetails.add(orderDetail);
			}
		} finally {
			DatabaseConnection.closeConnection();
		}
		return orderDetails;
	}

}