package ServletContext; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/11/29 16:40
 * 简介：域对象：共享数据
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContextDemo04", value = "/ContextDemo04")
public class ContextDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取httpservlet对象
        ServletContext context = this.getServletContext();

        //2. 获取数据
        Object msg = context.getAttribute("msg");

        System.out.println(msg);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
