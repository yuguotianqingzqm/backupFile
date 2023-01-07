package zjw.web.Servlet.FoodsServlet;
import zjw.domain.Foods;
import zjw.service.FoodsService;
import zjw.service.FoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllFoodsServlet")
public class FindAllFoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用SortService完成查询
        FoodsService service=new FoodsServiceImpl();
        List<Foods> foods=service.findAll();
        //2.将List存入request域中
        request.setAttribute("foods",foods);
            //判断是首页发来的请求还是后台发来的请求
        String login = request.getParameter("login");
        if(login==null||login.equals("")){
            login="qm";
        }
        if(login.equals("login")){
            //是首页，
            //将请求转发给首页login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }else {
            //3.转发到foodsList.jsp
            request.getRequestDispatcher("/foodList.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
