package zjw.web.Servlet.SortServlet;
import zjw.domain.Sort;
import zjw.service.SortService;
import zjw.service.SortServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllSortServlet")
public class FindAllSortServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用SortService完成查询
        SortService service=new SortServiceImpl();
        List<Sort> sort=service.findAll();
        //2.将List存入request域中
        request.setAttribute("sort",sort);

        //判断是谁发来的请求
        String name = request.getParameter("name");
        //防止空指针异常
        if(name==null){
            name="zjw";
        }
        if(name.equals("addFood")){
            //3.转发到addFood.jsp
            request.getRequestDispatcher("/addFood.jsp").forward(request,response);
        }else {
            //3.转发到sortList.jsp
            request.getRequestDispatcher("/sortList.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
