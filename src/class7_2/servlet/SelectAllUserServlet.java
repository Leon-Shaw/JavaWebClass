package class7_2.servlet;

import class7_2.dao.UsersDao;
import class7_2.domain.User;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectAllUserServlet",urlPatterns = "/SelectAllUserServlet")
public class SelectAllUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersDao usersDao = new UsersDao();
        List<User> users = usersDao.findAll();

        String jsonstr = JSON.toJSONString(users);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println(jsonstr);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
