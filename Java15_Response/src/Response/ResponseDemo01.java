package Response; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/11/25 13:52
 * 简介： 重定向
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ResponseDemo01", value = "/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo01....");

        // 重定向 方式一
        //1. 设置状态码为 302
//        response.setStatus(302);
        //2. 设置响应头Location
//        response.setHeader("location","/day15/responseDemo02");

        // 重定向 方式二（简便）
        response.sendRedirect("/day15/responseDemo02");
//        response.sendRedirect("https://www.baidu.com");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
