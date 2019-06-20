package com.furyfit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.furyfit.models.InterestLink;;

public class InterestLinksDAO {
	
	private static Connection conn;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String passwd = "Pg4e79joZ";
	private static String url = "jdbc:mysql://localhost:3306/furyfitproject?autoReconnect=true&useSSL=false";
	
	public static void deleteInterestingLink(int id) {
		conn = null;
		try	{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);
			
			Statement statement = conn.createStatement();
			statement.executeUpdate("DELETE From enlacesinteres WHERE ID="+id+";");
			
		} catch(ClassNotFoundException | SQLException e) {
			System.out.println("Error "+e+" al conectar");
		}
	}
	
	public static void updateLink(int id, String newURL, String newSRC) {
		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);

			String query = "UPDATE enlacesinteres SET LinkURL = ?, PictureSRC = ? WHERE ID = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, newURL);
			preparedStmt.setString(2, newSRC);
			preparedStmt.setInt(3, id);

			preparedStmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error " + e + " al conectar");
		}
	}
	
	public static void createIntrLink(int id, String newURL, String newSRC) {
		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);

			String query = " INSERT INTO enlacesinteres (ID, LinkURL, PictureSRC)" + " VALUES (?, ?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, id);
			preparedStmt.setString(2, newURL);
			preparedStmt.setString(3, newSRC);

			preparedStmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error " + e + " al conectar");
		}
	}
	
	public static List<InterestLink> getListOfInterestLinks() {
		List <InterestLink> list = new ArrayList<InterestLink>();
		conn = null;
		try	{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM enlacesinteres");
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				String pictureSRC = rs.getString("PictureSRC");
				String webLink = rs.getString("LinkURL");
				
				InterestLink myLink = new InterestLink(id, pictureSRC, webLink);
				list.add(myLink);
			}
			
		} catch(ClassNotFoundException | SQLException e) {
			System.out.println("Error "+e+" al conectar");
			String error = e.toString();
			InterestLink errItem = new InterestLink(0, error, error);
			list.add(errItem);
		}
		
		return list;
	}

}
