package zjw.web.Servlet.SortServlet;

import zjw.service.SortService;
import zjw.service.SortServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateSortServlet")
public class UpdateSortServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码问题
        request.setCharacterEncoding("utf-8");
        //拿到sortId
        String sortId = request.getParameter("sortId");
        //调service
        SortService sortService = new SortServiceImpl();
        sortService.deleteSort(sortId);
        //跳转到foodList.jsp
        response.sendRedirect(request.getContextPath()+"/findAllSortServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
