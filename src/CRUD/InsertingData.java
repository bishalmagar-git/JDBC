package CRUD;
import java.sql.*;

public class InsertingData {
    public static void main(String[] args) throws ClassCastException {
        String url = "jdbc:mysql://localhost:3306/Bishal";
        String username = "root";
        String password = "368893";
        String query = "INSERT into info(id,name,job_title,salary) values (3,'Binod','cleaner',120);";

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
                System.out.println("Insertion Sucessfull " + rowAffected + "rows affected.");
            } else {
                System.out.println("Insertion Failed.");
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
