package zjw.web.Servlet.UserServlet;
import org.apache.commons.beanutils.BeanUtils;
import zjw.domain.Sort;
import zjw.domain.User;
import zjw.service.SortService;
import zjw.service.SortServiceImpl;
import zjw.service.UserService;
import zjw.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/findByConditionServlet")
public class FindByConditionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //解决中文乱码问题
        request.setCharacterEncoding("utf-8");
        //封装对象
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user=new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService userService=new UserServiceImpl();
        List<User> userList = userService.findAllByCondition(user);
        //判断是否有该用户
        if(userList.size()==0){
          //没有该用户
            response.sendRedirect(request.getContextPath()+"sigiin.jsp");
        }else {
            HttpSession session = request.getSession();
            Cookie cookie= new Cookie("JSESSIONID", session.getId());
            //设置cookie的存活时间
            cookie.setMaxAge(60*60*24*30);//一个月
            //发送cookie该客户端
            //将用户信息存入存入session中
            session.setAttribute("user",userList);
            response.addCookie(cookie);
            //3.转发到
            response.sendRedirect(request.getContextPath()+"/loginServlet");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
