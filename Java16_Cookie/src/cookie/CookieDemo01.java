package cookie; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/12/1 09:52
 * 简介：cookie的快速入门
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookieDemo01", value = "/CookieDemo01")
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 创建cookie对象
        Cookie cookie = new Cookie("msg", "SAP");
        Cookie cookie1 = new Cookie("ABAP","HEHE");
        //2. 发送Cookie
        response.addCookie(cookie);
        response.addCookie(cookie1);
    }
}
