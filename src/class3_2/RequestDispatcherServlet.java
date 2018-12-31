package class3_2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestDispatcherServlet",urlPatterns = "/RequestDispatcherServlet")
public class RequestDispatcherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("company","WZVTC");
        response.setContentType("text/html;charset=utf-8");
        //RequestDispatcher requestDispatcher=request.getRequestDispatcher("class3_1/index.html");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/ResponseRedirectServlet");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
