package ServletContext; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/11/29 16:15
 * 简介： ServletContext对象获取
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ContextDemo01", value = "/ContextDemo01")
public class ContextDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            /**
             * 获取：
             * 		1. 通过request对象获取
             * 			request.getServletContext();
             *
             * 		2. 通过HttpServlet获取
             * 			this.getServletContext();
             */
        //1. 通过request对象获取
        ServletContext context1 = request.getServletContext();
        // 2. 通过HttpServlet获取
        ServletContext context2 = this.getServletContext();
        System.out.println(context2 == context1);
        System.out.println(context1);
        System.out.println(context2);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
