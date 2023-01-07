package zjw.web.Servlet.SortServlet;

import org.apache.commons.beanutils.BeanUtils;
import zjw.domain.Sort;
import zjw.service.SortServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addSortServlet")
public class AddSortServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码问题
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println(request.getParameter("sortName"));
        //封装对象
        Map<String, String[]> parameterMap = request.getParameterMap();
        Sort sort = new Sort();
        try {
            BeanUtils.populate(sort,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        SortServiceImpl sortService = new SortServiceImpl();
        sortService.add(sort);

        //先去/findAllSortServlet查询出来后会自动跳转发到 foodSort.jsp
        response.sendRedirect(request.getContextPath()+"/findAllSortServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
