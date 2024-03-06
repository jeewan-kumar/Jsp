
package com.studentmngsys.dob;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; 

public class StudentMgeSys_Dob {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/Library";
        String user = "postgres";
        String password = "root";
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            
            String sqlQuery = "YOUR_SQL_QUERY_HERE";
            statement.executeUpdate(sqlQuery); 
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
