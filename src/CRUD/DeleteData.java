package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Bishal";
        String username = "root";
        String password = "368893";
        String query = "Delete from info where id = 3";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver Loaded Successfully");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            //Establishing Connection
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established Successfully.");

            Statement stmt = conn.createStatement();

            int rowAffected = stmt.executeUpdate(query);

            if (rowAffected > 0) {
                System.out.println("Deleted Sucessfully " + rowAffected + "rows affected.");
            } else {
                System.out.println("Deletion Failed.");
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
