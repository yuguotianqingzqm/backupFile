package zjw.web.Servlet.FoodsServlet;
import zjw.service.FoodsService;
import zjw.service.FoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteFoodServlet")
public class DeleteFoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码问题
        request.setCharacterEncoding("utf-8");
        //拿到foodId
        String foodId = request.getParameter("foodId");
        //调service
        FoodsService foodsService = new FoodsServiceImpl();
        foodsService.deleteFood(foodId);
        //跳转到foodList.jsp
        response.sendRedirect(request.getContextPath()+"/findAllFoodsServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
