package ecommerce.com.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecommerce.com.models.user;
import ecommerce.com.utils.DatabaseConnection;

public class UserDao {
	public static List<user> getAllUser() throws SQLException {
		List<user> us = new ArrayList<user>();
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				user u = new user();
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

	public static void addUser(user u) throws SQLException {
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

	public static void deleteuUserById(int userId) throws SQLException {
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE user_id = ?");
			statement.setInt(1, userId);
			statement.executeUpdate();
		} finally {
			DatabaseConnection.closeConnection();
		}
	}

	public static void updateUser(user u) throws SQLException {
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

	public static user getuserById(int userId) throws SQLException {
		user u = null;
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE user_id = ?");
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				u = new user();
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

}