package zjw.web.Servlet.Order;

import zjw.domain.Foods;
import zjw.domain.Order;
import zjw.domain.OrderDetail;
import zjw.domain.User;
import zjw.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findOrderByUserIdServlet")
public class FindOrderByUserIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码问题
        request.setCharacterEncoding("utf-8");
//        获取userId
        List<User> userList = (List<User>) request.getSession().getAttribute("user");
        User user = userList.get(0);
//        查询
        OrderService orderService = new OrderServiceImpl();
        List<Order> order = orderService.findAllByCondition(user.getUserId());
        //查询出orderDetail表的数据
        List<OrderDetail> list=new ArrayList<>();
        OrderDetailService orderDetailService = new OrderDetailServiceImpl();
        //查询出foods表的图片
        List<Foods> foodsList=new ArrayList<>();
        FoodsService foodsService = new FoodsServiceImpl();
        for (Order order1 : order) {
            List<OrderDetail> orderDetails = orderDetailService.findAllByOrderId(order1.getOrderId());
            list.add(orderDetails.get(0));
            //添加食物图片
            List<Foods> foods = foodsService.findFoodsByFoodName(orderDetails.get(0).getFoodName());
            foodsList.add(foods.get(0));
        }

        request.setAttribute("orderDetail",list);
        request.setAttribute("foods",foodsList);
        request.getRequestDispatcher("/order.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
