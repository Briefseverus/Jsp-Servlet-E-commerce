package ecommerce.com.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecommerce.com.models.Role;
import ecommerce.com.utils.DatabaseConnection;

public class RoleDao {
	public static List<Role> getAllRole() throws SQLException {
		List<Role> pros = new ArrayList<Role>();
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM roles");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Role pro = new Role();
				pro.setRole_id(resultSet.getInt("role_id"));
				pro.setRole_name(resultSet.getString("role_name"));
				pros.add(pro);
			}
		} finally {
			DatabaseConnection.closeConnection();
		}
		return pros;
	}


	public static Role getRoleById(int RoleId) throws SQLException {
		Role pro = null;
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM roles WHERE role_id = ?");
			statement.setInt(1, RoleId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				pro = new Role();
				pro.setRole_id(resultSet.getInt("role_id"));
				pro.setRole_name(resultSet.getString("role_name"));
			}
		} finally {
			DatabaseConnection.closeConnection();
		}
		return pro;
	}

}