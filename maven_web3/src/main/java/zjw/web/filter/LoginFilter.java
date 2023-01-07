package zjw.web.filter;

import zjw.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(value = {"/loginServlet","/addressManage.jsp"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转换
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse) resp;
        //1.获取请求路径
        List<User> userList = (List<User>) request.getSession().getAttribute("user");
        if(userList==null||userList.get(0)==null){
            req.getRequestDispatcher("/sigiin.jsp").forward(req,resp);

//            response.sendRedirect(request.getContextPath()+"/sigiin.jsp");
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
