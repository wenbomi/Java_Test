package servlet; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2023/1/5 14:58
 * 简介：
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDemo02", value = "/user/ServletDemo02")
public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletDemo02...");

        // 转发到index.jsp
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
