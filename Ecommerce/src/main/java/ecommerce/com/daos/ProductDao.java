package ecommerce.com.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecommerce.com.models.product;
import ecommerce.com.utils.DatabaseConnection;

public class ProductDao {
	public static List<product> getAllproduct() throws SQLException {
		List<product> pros = new ArrayList<product>();
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM products");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				product pro = new product();
				pro.setProduct_id(resultSet.getInt("product_id"));
				pro.setProduct_name(resultSet.getString("product_name"));
				pro.setDescription(resultSet.getString("description"));
				pro.setPrice(resultSet.getBigDecimal("price"));
				pro.setQuantity(resultSet.getInt("quantity"));
				pros.add(pro);
			}
		} finally {
			DatabaseConnection.closeConnection();
		}
		return pros;
	}

}