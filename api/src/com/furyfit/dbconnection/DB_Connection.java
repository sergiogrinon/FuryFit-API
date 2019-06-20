package com.furyfit.dbconnection;

import java.sql.*;

public class DB_Connection {
	
	//Connection working
	private static Connection conn;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String passwd = "Pg4e79joZ";
	private static String url = "jdbc:mysql://localhost:3306/furyfitproject";
	
	public DB_Connection() {
		conn = null;
		try	{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);
			
			if (conn != null) {
				System.out.println("Conexión establecida con éxito!");
			}
		} catch(ClassNotFoundException | SQLException e) {
			System.out.println("Error "+e+" al conectar");
		}
	}

	public Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		DB_Connection.conn = conn;
	}

}
