package com.jsp.userapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class User_App_Db {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String password = "root";
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			
			if(connection != null) {
				System.out.println("connection database sucessfully");
				connection.close();
				System.out.println("connection close");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("postgresql driver not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection failed, check the connection");
			e.printStackTrace();
		}
	}
}
