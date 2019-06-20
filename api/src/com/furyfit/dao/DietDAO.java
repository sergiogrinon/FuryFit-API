package com.furyfit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.furyfit.dbconnection.*;
import java.util.List;
import com.furyfit.models.Diet;

public class DietDAO {
	
	private static Connection conn;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String passwd = "Pg4e79joZ";
	private static String url = "jdbc:mysql://localhost:3306/furyfitproject?autoReconnect=true&useSSL=false";
	
	public static void deleteDiet(int id) {
		conn = null;
		try	{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);
			
			Statement statement = conn.createStatement();
			statement.executeUpdate("DELETE From dietas WHERE ID="+id+";");
			
		} catch(ClassNotFoundException | SQLException e) {
			System.out.println("Error "+e+" al conectar");
		}
	}
	
	public static void updateDiet(int id, String newName, String newType, String newDesc) {
		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);

			String query = "UPDATE dietas SET Nombre = ?, Tipo = ?, Descripcion = ? where ID = ?";
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
	
	public static void createDiet(int id, String newName, String newType, String newDesc) {
		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);

			String query = " INSERT INTO dietas (ID, Nombre, Tipo, Descripcion)" + " VALUES (?, ?, ?, ?)";
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
	
	public static List<Diet> getListOfDiets() {
		List <Diet> list = new ArrayList<Diet>();
		conn = null;
		try	{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM dietas");
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				String nombre = rs.getString("Nombre");
				String tipo = rs.getString("Tipo");
				String descripcion = rs.getString("Descripcion");
				Diet dieta = new Diet(id, nombre, tipo, descripcion);
				list.add(dieta);
			}
			
		} catch(ClassNotFoundException | SQLException e) {
			System.out.println("Error "+e+" al conectar");
			String error = e.toString();
			Diet diet = new Diet(0, error, "Error", "Error");
			list.add(diet);
		}
		
		return list;
	}
	
	public static List<Diet> getDiets() {
		List <Diet> list = new ArrayList<Diet>();
		
		DB_Connection conn = new DB_Connection();
		Connection dbconnection = conn.getConn();

		Diet diet = new Diet(0, "Nombre", "Tipo", "Descripcion");
		list.add(diet);

		try {
			Statement statement = dbconnection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM dietas");

			while (rs.next()) {
				int id = rs.getInt("ID");
				String nombre = rs.getString("Nombre");
				String tipo = rs.getString("Tipo");
				String descripcion = rs.getString("Descripcion");
				Diet dieta = new Diet(id, nombre, tipo, descripcion);
				list.add(dieta);
			}

		} catch (Exception e) {
			String error = e.toString();
			Diet problem = new Diet(9, error, "Habido", "Un error");
			list.add(problem);
		}

		return list;
	}

}
