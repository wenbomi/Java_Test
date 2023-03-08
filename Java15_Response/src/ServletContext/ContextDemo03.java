package ServletContext; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/11/29 16:40
 * 简介： 域对象：共享数据
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ContextDemo03", value = "/ContextDemo03")
public class ContextDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取对象
        ServletContext servletContext = this.getServletContext();

        //2. 设置数据
        servletContext.setAttribute("msg","SAP");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
