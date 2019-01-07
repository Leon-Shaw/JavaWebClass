package class7_1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Date;

@WebServlet(name = "InsertDBServlet", urlPatterns = "/InsertDBServlet")
public class InsertDBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javawebclassdb";
            String username = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO users(id,name,password,sex,age) VALUES (?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            Date date = new Date();
            String timestamp = String.valueOf(date.getTime() / 1000);
            pstmt.setInt(1, Integer.valueOf(timestamp));
            pstmt.setString(2, "putaoche");
            pstmt.setString(3, "12345");
            pstmt.setString(4, "女");
            pstmt.setInt(5, 20);
            int result = pstmt.executeUpdate();
            if (result != 0)
                response.getWriter().println("insert success");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
}
