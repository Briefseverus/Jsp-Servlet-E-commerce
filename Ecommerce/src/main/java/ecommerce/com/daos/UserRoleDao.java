package ecommerce.com.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecommerce.com.models.UserRole;
import ecommerce.com.utils.DatabaseConnection;

public class UserRoleDao {
	public static List<UserRole> getAllUserRole() throws SQLException {
		List<UserRole> pros = new ArrayList<UserRole>();
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM userroles");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				UserRole pro = new UserRole();
				pro.setUser_role_id(resultSet.getInt("user_role_id"));
				pro.setUser_id(resultSet.getInt("user_id"));
				pro.setRole_id(resultSet.getInt("role_id"));

				pros.add(pro);
			}
		} finally {
			DatabaseConnection.closeConnection();
		}
		return pros;
	}

	public static void addUserRole(UserRole pro) throws SQLException {
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO userroles(user_id, product_id, role_id) VALUES(?,?)");
			statement.setInt(1, pro.getUser_id());
			statement.setInt(2, pro.getRole_id());

			statement.executeUpdate();
		} finally {
			DatabaseConnection.closeConnection();
		}
	}

	public static void deleteUserRoleById(int UserRoleId) throws SQLException {
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM userroles WHERE user_role_id = ?");
			statement.setInt(1, UserRoleId);
			statement.executeUpdate();
		} finally {
			DatabaseConnection.closeConnection();
		}
	}

	public static void updateUserRole(UserRole pro) throws SQLException {
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("UPDATE userroles SET user_id = ?, role_id = ? WHERE user_role_id = ?");
			statement.setInt(1, pro.getUser_id());
			statement.setInt(2, pro.getRole_id());
			statement.setInt(3, pro.getUser_role_id());
			statement.executeUpdate();
		} finally {
			DatabaseConnection.closeConnection();

		}

	}

	public static UserRole getUserRoleById(int UserRoleId) throws SQLException {
		UserRole pro = null;
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM userroles WHERE user_role_id = ?");
			statement.setInt(1, UserRoleId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				pro = new UserRole();
				pro.setUser_role_id(resultSet.getInt("user_role_id"));
				pro.setUser_id(resultSet.getInt("user_id"));
				pro.setRole_id(resultSet.getInt("role_id"));
			}
		} finally {
			DatabaseConnection.closeConnection();
		}
		return pro;
	}

}