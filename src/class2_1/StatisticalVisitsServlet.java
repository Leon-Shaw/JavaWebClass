package class2_1;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "StatisticalVisitsServlet", urlPatterns = "/StatisticalVisitsServlet")
public class StatisticalVisitsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        ServletContext servletContext = this.getServletContext();
        Counter counter = (Counter) servletContext.getAttribute("counter");
        if (counter == null) {
            counter = new Counter(1);
            servletContext.setAttribute("counter", counter);
        }
        int data = counter.getCount();
        out.write("Number of visits: " + data);
        counter.addStep(1);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
