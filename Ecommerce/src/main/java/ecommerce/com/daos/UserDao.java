package ecommerce.com.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecommerce.com.models.User;
import ecommerce.com.utils.DatabaseConnection;

public class UserDao {
	public static List<User> getAllUser() throws SQLException {
		List<User> us = new ArrayList<User>();
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				User u = new User();
				u.setUser_id(resultSet.getInt("user_id"));
				u.setUsername(resultSet.getString("username"));
				u.setPassword(resultSet.getString("password"));
				u.setFull_name(resultSet.getString("full_name"));
				u.setEmail(resultSet.getString("email"));
				u.setPhone_number(resultSet.getString("phone_number"));
				us.add(u);
			}
		} finally {
			DatabaseConnection.closeConnection();
		}
		return us;
	}

	public static void addUser(User u) throws SQLException {
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO users(username, password, full_name, email, phone_number) VALUES(?,?,?,?,?)");
			statement.setString(1, u.getUsername());
			statement.setString(2, u.getPassword());
			statement.setString(3, u.getFull_name());
			statement.setString(4, u.getEmail());
			statement.setString(5, u.getPhone_number());
			statement.executeUpdate();
		} finally {
			DatabaseConnection.closeConnection();
		}
	}

	public static void deleteUserById(int userId) throws SQLException {
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE user_id = ?");
			statement.setInt(1, userId);
			statement.executeUpdate();
		} finally {
			DatabaseConnection.closeConnection();
		}
	}

	public static void updateUser(User u) throws SQLException {
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE users SET username = ?, password = ?, full_name = ?, email = ?, phone_number = ? WHERE user_id = ?");
			statement.setString(1, u.getUsername());
			statement.setString(2, u.getPassword());
			statement.setString(3, u.getFull_name());
			statement.setString(4, u.getEmail());
			statement.setString(5, u.getPhone_number());
			statement.setInt(6, u.getUser_id());
			statement.executeUpdate();
		} finally {
			DatabaseConnection.closeConnection();

		}

	}

	public static User getuserById(int userId) throws SQLException {
		User u = null;
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE user_id = ?");
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				u = new User();
				u.setUser_id(resultSet.getInt("user_id"));
				u.setUsername(resultSet.getString("username"));
				u.setPassword(resultSet.getString("password"));
				u.setFull_name(resultSet.getString("full_name"));
				u.setEmail(resultSet.getString("email"));
				u.setPhone_number(resultSet.getString("phone_number"));
			}
		} finally {
			DatabaseConnection.closeConnection();
		}
		return u;
	}

	public static int getLastUserId() throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int lastUserId = 0;

		try {
			connection = DatabaseConnection.getConnection();
			statement = connection.prepareStatement("SELECT MAX(user_id) as last_user_id FROM users");
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				lastUserId = resultSet.getInt("last_user_id");
			}
		} finally {
			DatabaseConnection.closeConnection();
		}
		return lastUserId;
	}
	public static User authenticate(String username, String password) throws SQLException {
	    User user = null;
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = DatabaseConnection.getConnection();
	        statement = connection.prepareStatement("SELECT u.user_id, u.username, u.password, u.full_name, u.email, u.phone_number, ur.role_id FROM users u JOIN userroles ur ON u.user_id = ur.user_id WHERE u.username = ? AND u.password = ?");
	        statement.setString(1, username);
	        statement.setString(2, password);
	        resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            user = new User();
	            user.setUser_id(resultSet.getInt("user_id"));
	            user.setUsername(resultSet.getString("username"));
	            user.setPassword(resultSet.getString("password"));
	            user.setFull_name(resultSet.getString("full_name"));
	            user.setEmail(resultSet.getString("email"));
	            user.setPhone_number(resultSet.getString("phone_number"));
	            user.setRole_id(resultSet.getInt("role_id"));
	        }
	    } finally {
	        DatabaseConnection.closeConnection();
	    }

	    return user;
	}



}