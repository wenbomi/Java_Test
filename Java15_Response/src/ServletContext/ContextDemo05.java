package ServletContext; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/11/29 16:49
 * 简介：获取文件的真实(服务器)路径
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "ContextDemo05", value = "/ContextDemo05")
public class ContextDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取对象
        ServletContext context = this.getServletContext();
        //2. 获取真实路径
        String realPath = context.getRealPath("/b.txt");  // web目录下的
        System.out.println(realPath);

        String realPath1 = context.getRealPath("/WEB-INF/c.txt"); // WEB-INF下的
        System.out.println(realPath1);

        String realPath2 = context.getRealPath("/WEB-INF/classes/a.txt"); // src下的资源访问（最麻烦）
        System.out.println(realPath2);

        File file = new File(realPath);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
