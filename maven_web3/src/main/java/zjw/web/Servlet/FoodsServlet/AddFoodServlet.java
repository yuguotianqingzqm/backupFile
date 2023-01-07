package zjw.web.Servlet.FoodsServlet;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import zjw.domain.Foods;
import zjw.service.FoodsServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/addFoodServlet")
public class AddFoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码问题
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //封装对象
        Map<String,String> map=new HashMap<>();
        Foods foods = new Foods();

        //拿到传来的sortId
        String sortId = request.getParameter("sortId");
        map.put("sortId",sortId);
        //将前台的文件上传到服务器
        try {
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            //判断前台表单是否有multipart属性
            if(isMultipart){
                DiskFileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                //通过parseRequest解析form中的所有请求字段，并保存到items集合中
                    List<FileItem> items = upload.parseRequest(request);
                    //遍历集合
                for (FileItem item : items) {
                    //拿到表单的name值
                    String name = item.getFieldName();
                    //判断前台表单是普通字段还是文件字段
                    if(item.isFormField()){
                    //普通字段，直接添加到map集合
                        map.put(name,item.getString("utf-8"));
                    }else {
                        //是文件，上传到到服务器的images里
                        //getFieldName是获取普通字段的name值，getName是获取文件名
                        String fileName = item.getName();
                        //添加文件名到map
                        map.put("foodImage",fileName);
                        //获取要上传的路径
                        //通过HttpServlet获取
                        ServletContext servletContext = this.getServletContext();
                        String realPath = servletContext.getRealPath("/upload");

                        File file = new File(realPath, fileName);
                        //上传
                        item.write(file);
                    }
                }
            }
        }catch (FileUploadException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //调用Service保存到数据库
        FoodsServiceImpl foodsService = new FoodsServiceImpl();
        try {
            BeanUtils.populate(foods,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        foodsService.addFoods(foods);

        //跳转到/findAllFoodsServlet进行查询
        response.sendRedirect(request.getContextPath()+"/findAllFoodsServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
