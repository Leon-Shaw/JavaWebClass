package class6_2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginDBServlet", urlPatterns = "/LoginDBServlet")
public class LoginDBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javawebclassdb";
            String username = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            String sql = "select * from users";
            rs = stmt.executeQuery(sql);
            System.out.println("    id  |   name        |   password    |   sex |   age ");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String psw = rs.getString("password");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                System.out.println("    " + id + "   |   " + name + "    |      " + psw + "    |   " + sex + "    |   " + age);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                stmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
