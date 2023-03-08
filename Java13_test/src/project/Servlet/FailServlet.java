package project.Servlet;
/**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/11/23 15:40
 * 简介：
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
@WebServlet(name = "failServlet", value = "/failServlet")
public class FailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 展示一句话
        // 设置编码
        response.setContentType("text/html;charset = utf-8");
        //展示数据
        response.getWriter().write("登陆失败，用户名或者是密码错误！");
    }
}
