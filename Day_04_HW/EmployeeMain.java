package Day4.Day_04_HW;
import java.sql.*;

public class EmployeeMain {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:\\Users\\dev\\Desktop\\sdaia_java_projects\\project-01\\hr.db";
        String query = "select * from employees";

        try(Connection conn = DriverManager.getConnection(url);) {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Employee e = new Employee(rs);
                System.out.println(e);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
