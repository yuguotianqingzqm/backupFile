package zjw.web.Servlet.AddressManage.servlet;
import zjw.domain.AddressManage;
import zjw.domain.Foods;
import zjw.domain.User;
import zjw.service.AddressManageService;
import zjw.service.AddressManageServiceImpl;
import zjw.service.FoodsService;
import zjw.service.FoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllByUserIdServlet")
public class FindAllByUserIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用SortService完成查询
        AddressManageService addressManageService=new AddressManageServiceImpl();
//        获取userId
        List<User> userList = (List<User>) request.getSession().getAttribute("user");
        User user = userList.get(0);

        List<AddressManage> addressManages=addressManageService.findByUserId(user.getUserId());
        //2.将List存入request域中
        request.setAttribute("addressManages",addressManages);

            //3.转发到foodsList.jsp
            request.getRequestDispatcher("/addressManage.jsp").forward(request, response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
