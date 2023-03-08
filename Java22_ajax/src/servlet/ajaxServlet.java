package servlet; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2023/2/18 15:56
 * 简介：
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/ajaxServlet")
public class ajaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求参数
        String username = request.getParameter("username");
        // 等待5秒后
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        //2 打印username
        System.out.println(username); // 答应username键的值

        //3 响应
        response.getWriter().write("hello : " + username); // 返回的值给data
    }
}
