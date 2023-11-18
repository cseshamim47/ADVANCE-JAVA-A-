import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@WebServlet("/add-employee")
public class AddEmployee extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        String id,name,dob,email,joindate,empType;

        id = req.getParameter("id");
        name = req.getParameter("name");
        dob = req.getParameter("dob");
        email = req.getParameter("email");
        joindate = req.getParameter("joindate");
        empType = req.getParameter("empType");

        PrintWriter out = res.getWriter();

        try {
            Connection connection = ConnectionManager.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Employee employee;
        if(empType.equals("Officer"))
        {
            employee = new Employee(id,name,dob,email,joindate,empType,15,10);
//            System.out.println(employee.getVacation());
//            System.out.println(employee.getVacationLeave());
        }else {
            employee = new Employee(id,name,dob,email,joindate,empType,10,7);
        }

        try {
            Model.create(employee);
            res.sendRedirect("show-all-employee");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        out.println("User Added Successfully!");



    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();

        out.println("I have came");

        try {
            Connection connection = ConnectionManager.getConnection();
            String sql = "SELECT id, name FROM user_info";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                out.println(id + " " + name);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}