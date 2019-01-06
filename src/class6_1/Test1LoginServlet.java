package class6_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Test1LoginServlet",urlPatterns = "/Test1LoginServlet")
public class Test1LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String username1=request.getParameter("username");
        String password1=request.getParameter("password");
        String username2=(String)session.getAttribute("username");
        String password2=(String)session.getAttribute("password");
        if(username1.equals(username2)&&password1.equals(password2))
            response.sendRedirect("class6_1/index.html");
        else
            response.sendRedirect("class6_1/error.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
