package zjw.web.Servlet.AddressManage.servlet;

import org.apache.commons.beanutils.BeanUtils;
import zjw.domain.AddressManage;
import zjw.domain.User;
import zjw.service.AddressManageService;
import zjw.service.AddressManageServiceImpl;
import zjw.service.UserService;
import zjw.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@WebServlet("/addAddressServlet")
public class AddAddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码问题
        request.setCharacterEncoding("utf-8");
        //封装对象
        Map<String, String[]> parameterMap = request.getParameterMap();
        AddressManage addressManage = new AddressManage();
        //添加UserId
        List<User> userList = (List<User>) request.getSession().getAttribute("user");
        User user = userList.get(0);
        addressManage.setUserId(user.getUserId());
        try {
            BeanUtils.populate(addressManage,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        AddressManageService addressManageService = new AddressManageServiceImpl();
        addressManageService.addAddressManage(addressManage);
        //3.转发到
        request.getRequestDispatcher("/findAllByUserIdServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
