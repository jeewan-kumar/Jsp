package com.jsp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_Table_Books {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/library";
			String user = "postgres";
			String password = "root";
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			String create = "create table if not exists book (book_id serial primary key,title varchar(50),author varchar(50),price bigint,publication_year bigint,issued_date bigint,status varchar(50),library_id bigint)";
			statement.execute(create);
			statement.close();
			connection.close();
			System.out.println("Table 'book' created successfully.");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


