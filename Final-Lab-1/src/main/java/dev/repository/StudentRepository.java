package dev.repository;

import dev.domain.Gender;
import dev.domain.Student;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class StudentRepository {

    private DataSource dataSource;

    public StudentRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void create(Student student) throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(student.toString());
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (id, name, email, dateOfBirth, gender, quota, country) VALUES (?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, student.getId());
        preparedStatement.setString(2, student.getName());
        preparedStatement.setString(3, student.getEmail());
        preparedStatement.setDate(4, Date.valueOf(student.getDateOfBirth()));
        preparedStatement.setString(5, student.getGender().name());
        preparedStatement.setString(6, student.getQuota());
        preparedStatement.setString(7, student.getCountry());
        preparedStatement.execute();
    }

    public void update(Student student) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE students set name = ?, email = ?, password = ?, dateOfBirth = ?, gender = ?, quota = ?, country = ? WHERE id = ?");
        preparedStatement.setInt(1, student.getId());
        preparedStatement.setString(2, student.getName());
        preparedStatement.setString(3, student.getEmail());
        preparedStatement.setDate(4, Date.valueOf(student.getDateOfBirth()));
        preparedStatement.setString(5, student.getGender().name());
        preparedStatement.setString(6, student.getQuota());
        preparedStatement.setString(7, student.getCountry());
        preparedStatement.execute();
    }

//    public Student get(String email) throws SQLException {
//        Connection connection = dataSource.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, email, dateOfBirth, gender, quota, country FROM students WHERE id = ?");
//        preparedStatement.setString(1, email);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            return new Student(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getString("email"), resultSet.getDate("date_of_birth").toLocalDate(), Gender.valueOf(resultSet.getString("gender").toUpperCase()),resultSet.getString("quota"),resultSet.getString("country"));
//        }
//        return new Student();
//    }
}
