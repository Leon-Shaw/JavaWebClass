package class5_1;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CharacterFilter", urlPatterns = "/*")
public class CharacterFilter implements Filter {
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        request.setAttribute("filterdata", "Filter Test");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化");
    }

}
