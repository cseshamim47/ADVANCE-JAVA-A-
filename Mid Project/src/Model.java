import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Model {

    public static List<EmployeeAtt> getAll() throws SQLException, ClassNotFoundException {
        List<EmployeeAtt> Employees = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        String sql = "SELECT * FROM employee";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            Employees.add(new EmployeeAtt(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)
                    ));
        }
        return Employees;
    }

    public static void create(Employee p) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionManager.getConnection();
        String sql = "INSERT INTO employee SET id = ?, name = ?, dob = ?, email = ?, joindate = ?, usertype = ?, vacationleave = ?, sickleave = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, p.getId());
        preparedStatement.setString(2, p.getName());
        preparedStatement.setString(3, p.getDob());
        preparedStatement.setString(4, p.getEmail());
        preparedStatement.setString(5, p.getJoindate());
        preparedStatement.setString(6, p.getUserType());
        preparedStatement.setString(7, String.valueOf(p.getVacationLeave()));
        preparedStatement.setString(8, String.valueOf(p.getSickLeave()));
        preparedStatement.execute();
    }


}