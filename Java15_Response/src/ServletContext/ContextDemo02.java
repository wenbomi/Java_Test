package ServletContext; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/11/29 16:32
 * 简介：ServletContext对象功能
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ContextDemo02", value = "/ContextDemo02")
public class ContextDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取MIME类型： 通过HttpServlet
        ServletContext context = this.getServletContext();

        //2. 定义文件名称
        String fieldname = "a.jpg";

        //3. 获取MIME类型
        String mimeType = context.getMimeType(fieldname);
        System.out.println(mimeType);  //image/jpeg （图片格式）

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
