import java.sql.*;
import java.util.Scanner;

public class PreparedStatementDemo {
    public static void main(String[] args) throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/Bishal";
        String username = "root";
        String password = "368893";
        String query = "SELECT * FROM info WHERE name=?";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver Loaded Successfully");
        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }

        try {
            //Establishing Connection
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established Successfully.");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();

            int id = scanner.nextInt();
            String name = scanner.next();
            String job_title = scanner.next();
            double salary = scanner.nextDouble();

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(1,name);
            preparedStatement.setString(1,job_title);
            preparedStatement.setDouble(1,salary);

            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
