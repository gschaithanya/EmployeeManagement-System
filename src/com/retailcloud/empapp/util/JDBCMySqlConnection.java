package com.retailcloud.empapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCMySqlConnection {
	private static JDBCMySqlConnection instance = new JDBCMySqlConnection();
	public static final String URL = "jdbc:mysql://localhost:3306/empapp";
	public static final String USER = "root";
	public static final String PASSWORD = "Mysql@1234";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	private JDBCMySqlConnection() {
		 try {
	           //Step 2: Load MySQL Java driver
	           Class.forName(DRIVER_CLASS);
	       } catch (ClassNotFoundException e) {
	           e.printStackTrace();
	       }
		 
	}
	private Connection createConnection() {

		Connection connection = null;
		try {
			
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to Connect to Database.");
		}
		return connection;
	}

	public static Connection getConnection() {
		return instance.createConnection();
	}

}
