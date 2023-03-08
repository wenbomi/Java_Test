package project.Servlet; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/11/23 15:41
 * 简介：
 */

import project.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet( "/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取公共域中的数据
        User user = (User) request.getAttribute("user");
        if (user != null) {
            // 展示一句话
            // 设置编码
            response.setContentType("text/html;charset = utf-8");
            //展示数据
            response.getWriter().write("登陆成功，欢迎" + user.getUsername() + "您的到来！");
        }
    }
}
