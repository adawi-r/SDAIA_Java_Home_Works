package Day4.Day_04_HW;


import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {

    private static final String URL = "jdbc:sqlite:C:\\Users\\dev\\Desktop\\sdaia_java_projects\\project-01\\hr.db";
    private static final String SELECT_ALL_EMPLOYEE = "select * from employees";
    private static final String SELECT_ONE_EMPLOYEE = "select * from employees where employee_id = ?";
    private static final String INSERT_EMPLOYEE = "insert into employees values (?, ?, ?, ?)";
    private static final String UPDATE_EMPLOYEE = "update employees set employee_id = ?, first_name = ? where last_name = ? where phone_number = ?";
    private static final String DELETE_EMPLOYEE = "delete from employees where employee_id = ?";

    public void insertEMP(Employee e) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(INSERT_EMPLOYEE);
        st.setInt(1, e.getEmployee_id());
        st.setString(2, e.getFirst_name());
        st.setString(3, e.getLast_name());
        st.setString(4, e.getPhone_number());
        st.setString(5, e.getEmail());
        st.setString(6, e.getHire_date());
        st.setInt(7, e.getJob_id());
        st.setDouble(8, e.getSalary());
        st.setInt(9, e.getManager_id());
        st.setInt(10, e.getDepartment_id());

        st.executeUpdate();
    }

    public void updateEMP(Employee e) throws SQLException {

        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_EMPLOYEE);
        st.setInt(1, e.getEmployee_id());
        st.setString(2, e.getFirst_name());
        st.setString(3, e.getLast_name());
        st.executeUpdate();
    }

    public void deleteEMP(int employee_id) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_EMPLOYEE);
        st.setInt(1, employee_id);
        st.executeUpdate();
    }

    public Employee selectEMP(int employee_id) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_EMPLOYEE);
        st.setInt(1, employee_id);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new Employee(rs);
        }
        else {
            return null;
        }
    }

    public ArrayList<Employee> selectAllEMP() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ALL_EMPLOYEE);
        ResultSet rs = st.executeQuery();
        ArrayList<Employee> emp = new ArrayList<>();
        while (rs.next()) {
            emp.add(new Employee(rs));
        }

        return emp;
    }

}
