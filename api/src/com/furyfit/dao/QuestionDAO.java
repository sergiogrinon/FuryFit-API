package com.furyfit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.furyfit.models.Question;

public class QuestionDAO {

	private static Connection conn;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String passwd = "Pg4e79joZ";
	private static String url = "jdbc:mysql://localhost:3306/furyfitproject?autoReconnect=true&useSSL=false";
	
	public static void deleteQuestion(int id) {
		conn = null;
		try	{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);
			
			Statement statement = conn.createStatement();
			statement.executeUpdate("DELETE From faqs WHERE ID="+id+";");
			
		} catch(ClassNotFoundException | SQLException e) {
			System.out.println("Error "+e+" al conectar");
		}
	}
	
	public static void createFAQ(int id, String newQuestion, String newAnswer) {
		//Must make the Question Here (add the question marks)
		String questionTitle = "¿"+ newQuestion +"?";
		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);

			String query = " INSERT INTO faqs (ID, Titulo, Respuesta)" + " VALUES (?, ?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, id);
			preparedStmt.setString(2, questionTitle);
			preparedStmt.setString(3, newAnswer);

			preparedStmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error " + e + " al conectar");
		}
	}
	
	public static void updateFAQ(int id, String newQuestion, String newAnswer) {
		String questionTitle = "¿"+ newQuestion +"?";
		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);

			String query = "UPDATE faqs SET Titulo = ?, Respuesta = ? WHERE ID = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, questionTitle);
			preparedStmt.setString(2, newAnswer);
			preparedStmt.setInt(3, id);

			preparedStmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error " + e + " al conectar");
		}
	}

	public static List<Question> getListOfFAQs() {
		
		List<Question> list = new ArrayList<Question>();
		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM faqs");

			while (rs.next()) {
				int id = rs.getInt("ID");
				String questionTitle = rs.getString("Titulo");
				String answerText = rs.getString("Respuesta");

				Question myLink = new Question(id, questionTitle, answerText);
				list.add(myLink);
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error " + e + " al conectar");
			String error = e.toString();
			Question errItem = new Question(0, error, error);
			list.add(errItem);
		}

		return list;
	}

}
