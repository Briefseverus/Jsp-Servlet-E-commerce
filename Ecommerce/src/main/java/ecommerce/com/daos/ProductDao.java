package ecommerce.com.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecommerce.com.models.Product;
import ecommerce.com.utils.DatabaseConnection;

public class ProductDao {
	public static List<Product> getAllproduct() throws SQLException {
		List<Product> pros = new ArrayList<Product>();
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM products");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Product pro = new Product();
				pro.setProduct_id(resultSet.getInt("product_id"));
				pro.setProduct_name(resultSet.getString("product_name"));
				pro.setDescription(resultSet.getString("description"));
				pro.setPrice(resultSet.getBigDecimal("price"));
				pro.setProduct_img(resultSet.getString("product_img"));
				pro.setQuantity(resultSet.getInt("quantity"));
				pros.add(pro);
			}
		} finally {
			DatabaseConnection.closeConnection();
		}
		return pros;
	}

	public static void addProduct(Product pro) throws SQLException {
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO products(product_name, description, price, product_img, quantity) VALUES(?,?,?,?,?)");
			statement.setString(1, pro.getProduct_name());
			statement.setString(2, pro.getDescription());
			statement.setBigDecimal(3, pro.getPrice());
			statement.setString(4, pro.getProduct_img());
			statement.setInt(5, pro.getQuantity());
			statement.executeUpdate();
		} finally {
			DatabaseConnection.closeConnection();
		}
	}

	public static void deleteProductById(int productId) throws SQLException {
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE product_id = ?");
			statement.setInt(1, productId);
			statement.executeUpdate();
		} finally {
			DatabaseConnection.closeConnection();
		}
	}

	public static void updateProduct(Product pro) throws SQLException {
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE products SET product_name = ?, description = ?, price = ?, product_img = ?, quantity = ? WHERE product_id = ?");
			statement.setString(1, pro.getProduct_name());
			statement.setString(2, pro.getDescription());
			statement.setBigDecimal(3, pro.getPrice());
			statement.setString(4, pro.getProduct_img());
			statement.setInt(5, pro.getQuantity());
			statement.setInt(6, pro.getProduct_id());
			statement.executeUpdate();
		} finally {
			DatabaseConnection.closeConnection();

		}

	}

	public static Product getProductById(int productId) throws SQLException {
		Product pro = null;
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM products WHERE product_id = ?");
			statement.setInt(1, productId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				pro = new Product();
				pro.setProduct_id(resultSet.getInt("product_id"));
				pro.setProduct_name(resultSet.getString("product_name"));
				pro.setDescription(resultSet.getString("description"));
				pro.setPrice(resultSet.getBigDecimal("price"));
				pro.setProduct_img(resultSet.getString("product_img"));
				pro.setQuantity(resultSet.getInt("quantity"));
			}
		} finally {
			DatabaseConnection.closeConnection();
		}
		return pro;
	}

}