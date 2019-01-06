package class5_2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "StatisticalVisits3Servlet", urlPatterns = "/StatisticalVisits3Servlet")
public class StatisticalVisits3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.getWriter().println("欢迎访问，本次访问已经计数");
        if (session.getAttribute("CountVisits") == null) {
            session.setAttribute("CountVisits", 1);
        } else {
            Integer count = (Integer) session.getAttribute("CountVisits");
            session.setAttribute("CountVisits", ++count);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
