package com.furyfit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.furyfit.models.User;

public class UserDAO {

	private static Connection conn;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String passwd = "Pg4e79joZ";
	private static String url = "jdbc:mysql://localhost:3306/furyfitproject?autoReconnect=true&useSSL=false";

	public static List<User> getLoggedUserIfExist(String username) {
		List<User> loggedUser = new ArrayList<User>();

		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM pageusers WHERE Username='"+username+"';");

			while (rs.next()) {
				String nombre = rs.getString("Nombre");
				String apellido = rs.getString("Apellido");
				String email = rs.getString("Email");
				String usern = rs.getString("Username");
				String sexo = rs.getString("Sexo");
				String objetivo = rs.getString("Objetivo");
				String specialC = rs.getString("CaracEspeciales");
				int edad = rs.getInt("Edad");
				float peso = rs.getInt("Peso");
				float altura = rs.getInt("Altura");
				
				User myUser = new User(edad, altura, peso, nombre, apellido, usern, email, sexo, objetivo, specialC);
				loggedUser.add(myUser);
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error " + e + " al conectar");
		}

		return loggedUser;
	}

}
