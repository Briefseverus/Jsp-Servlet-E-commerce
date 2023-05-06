package com.example.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Megazine;
import com.example.utils.DatabaseConnection;

public class MegazineDao {
	public static List<Megazine> getAllMegazine() throws SQLException {
		List<Megazine> megs = new ArrayList<Megazine>();
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM megazine_52188");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Megazine meg = new Megazine();
				meg.setID(resultSet.getString("id"));
				meg.setTitle(resultSet.getString("title"));
				meg.setPublisher(resultSet.getString("publisher"));
				meg.setPrice(resultSet.getDouble("price"));
				megs.add(meg);
			}
		} finally {
			DatabaseConnection.closeConnection();
		}
		return megs;
	}

	public static void createMegazine(Megazine meg) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatabaseConnection.getConnection();
			statement = connection
					.prepareStatement("INSERT INTO megazine_52188 (id,title, publisher, price) VALUES (?,?, ?, ?)");
			statement.setString(1, meg.getID());
			statement.setString(2, meg.getTitle());
			statement.setString(3, meg.getPublisher());
			statement.setDouble(4, meg.getPrice());
			statement.executeUpdate();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	public static void deleteMegazine(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatabaseConnection.getConnection();
			statement = connection.prepareStatement("DELETE FROM megazine_52188 WHERE id = ?");
			statement.setString(1, id);
			statement.executeUpdate();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	public static Megazine getMegazineById(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnection.getConnection();
			statement = connection.prepareStatement("SELECT * FROM megazine_52188 WHERE id = ?");
			statement.setString(1, id);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				Megazine meg = new Megazine();
				meg.setID(resultSet.getString("id"));
				meg.setTitle(resultSet.getString("title"));
				meg.setPublisher(resultSet.getString("publisher"));
				meg.setPrice(resultSet.getDouble("price"));
				return meg;
			} else {
				return null;
			}
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	public static void updateMegazine(Megazine meg) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatabaseConnection.getConnection();
			statement = connection
					.prepareStatement("UPDATE megazine_52188 SET title = ?, publisher = ?, price = ? WHERE id = ?");
			statement.setString(1, meg.getTitle());
			statement.setString(2, meg.getPublisher());
			statement.setDouble(3, meg.getPrice());
			statement.setString(4, meg.getID());
			statement.executeUpdate();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

}
