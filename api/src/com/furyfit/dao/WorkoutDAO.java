package com.furyfit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.furyfit.models.Workout;

public class WorkoutDAO {

	private static Connection conn;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String passwd = "Pg4e79joZ";
	private static String url = "jdbc:mysql://localhost:3306/furyfitproject?autoReconnect=true&useSSL=false";

	public static void deleteWorkout(int id) {
		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);

			Statement statement = conn.createStatement();
			statement.executeUpdate("DELETE From entrenamientos WHERE ID=" + id + ";");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error " + e + " al conectar");
		}
	}

	public static void updateWorkout(int id, String newName, String newType, String newDesc) {
		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);

			String query = "UPDATE entrenamientos SET Nombre = ?, Tipo = ?, Descripcion = ? where ID = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, newName);
			preparedStmt.setString(2, newType);
			preparedStmt.setString(3, newDesc);
			preparedStmt.setInt(4, id);

			preparedStmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error " + e + " al conectar");
		}
	}
	
	public static void createWorkout(int id, String newName, String newType, String newDesc) {
		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);

			String query = " INSERT INTO entrenamientos (ID, Nombre, Tipo, Descripcion)" + " VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, id);
			preparedStmt.setString(2, newName);
			preparedStmt.setString(3, newType);
			preparedStmt.setString(4, newDesc);

			preparedStmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error " + e + " al conectar");
		}
	}

	public static List<Workout> getListOfWorkouts() {
		List<Workout> list = new ArrayList<Workout>();
		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM entrenamientos");

			while (rs.next()) {
				int id = rs.getInt("ID");
				String nombre = rs.getString("Nombre");
				String tipo = rs.getString("Tipo");
				String descripcion = rs.getString("Descripcion");
				Workout entrenamiento = new Workout(id, nombre, tipo, descripcion);
				list.add(entrenamiento);
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error " + e + " al conectar");
		}

		return list;
	}

}
