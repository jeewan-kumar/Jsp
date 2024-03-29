package com.computer;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Computer extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
        String brand = req.getParameter("brand");
        String processor = req.getParameter("processor");
        int ram = Integer.parseInt(req.getParameter("ram"));
        String operatingsystem = req.getParameter("operatingsystem");

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student", "postgres", "root");
            String insert = "insert into computer (computerid, brand, processor, ram, operatingsystem) values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, brand);
            preparedStatement.setString(3, processor);
            preparedStatement.setInt(4, ram);
            preparedStatement.setString(5, operatingsystem);

            int updated = preparedStatement.executeUpdate();
            PrintWriter writer = resp.getWriter();

            if(updated > 0) {
                writer.write("<html><body>");
                writer.write("<h1>Book registration successful</h1>");
                writer.write("</body></html>");
            } else {
                writer.write("<html><body>");
                writer.write("<h1>Book registration failed</h1>");
                writer.write("</body></html>");
            }

            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	

}
