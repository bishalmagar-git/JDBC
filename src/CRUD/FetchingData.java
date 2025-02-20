import java.sql.*;

public class FetchingData {
    public static void main(String[] args) throws ClassCastException{
        String url = "jdbc:mysql://localhost:3306/Bishal";
        String username = "root";
        String password = "368893";
        String query = "SELECT * FROM info";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver Loaded Successfully");
        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }

        try{
            //Establishing Connection
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connection established Successfully.");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");

                System.out.println("ID: "+ id);
                System.out.println("Name: "+ name);
                System.out.println("Job Title: "+ job_title);
                System.out.println("Salary: "+ salary);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
